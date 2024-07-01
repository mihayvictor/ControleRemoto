package model;

import java.util.function.Supplier;

public class ControleTV extends Control{
    private int channel;
    
     public ControleTV(){
        channel = 10;
    }

     //Método de ligar/desligar
     @Override
     public String power() {
        setPower();
        return isPower() ? "Tv Ligada" : "TV Desligada";
    }

    //Método para mudar volume para +
    @Override
    public String moreVol(){
        return executeIfPowered(() -> {
            if (getVolume() < 100) {
                setVolume(getVolume()+1);
            }else{
                setVolume(0);
            }
        
        return viewVol();
        });
    }

    //Método para mudar volume para -
    @Override
    public String lessVol(){
        return executeIfPowered(() -> {
        if (getVolume() > 0) {
            setVolume(getVolume()-1);
        }
        else{
            setVolume(100);
        }   
        return viewVol();
        });
    }

     //Método mute (colocar e tirar do mudo)
     @Override 
     public String mute(){
        if (getVolume() != 0) {
            setVolume(0);
        }else{
            setVolume(getVolume()+1);
        }    
        return viewVol();
    }

     //Método para viewificar qual o volume
     @Override 
     public String viewVol() {
        return isPower()? " Volume " + getVolume() : "TV desligada";
    }

     //Método de mudar canal para + 
     public String moreChannels() {
        return executeIfPowered(() -> {
            if (getChannel() == 99) {
                setChannel(0);
            }else{
                setChannel(getChannel()+1);
            } 
        
        return viewChannel();
        });
    }

    //Método de mudar Canal para -
    public String lessChannels() {
        return executeIfPowered(() -> {
        if (getChannel() == 0) {
            setChannel(99);
        }else{
            setChannel(getChannel()-1);
        }
            return viewChannel();
        });
    }   
    
    //Método Realizar mudança de canal diretamente
    public String fixChannel(int fixChannel) {
        return executeIfPowered(() -> {
            setChannel(fixChannel);
            return viewChannel();
        });              
    }

    //Métdo para viewificar qual o channel 
    public String viewChannel(){
         return isPower()? "Canal " + getChannel() : "Tv desligada";
    }

    public String info(){
        return isPower() ? viewChannel() + "\n" + viewVol() : "TV desligada";
    }

    //métodos de acesso (getter e setter) ao canal
    private int getChannel() {
        if (isPower() == true){
        }return channel;
    }

    private void setChannel(int channel) {
            this.channel = channel;
    }
    
     // Método auxiliar para executar ação se a TV estiver ligada
     protected String executeIfPowered(Supplier<String> action) {
        return isPower() ? action.get() : "TV desligada";
    }

}
