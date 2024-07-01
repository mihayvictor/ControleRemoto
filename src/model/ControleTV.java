package model;

import java.util.function.Supplier;

public class ControleTV extends Control{
    private int canal;
    
     public ControleTV(){
        canal = 10;
    }

     //Méto de ligar/desligar
     public String power() {
        setPower();
        return isPower() ? "Tv Ligada" : "TV Desligada";
    }

    //Método para mudar volume para +
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
     public void mute(){
        if (getVolume() != 0) {
            setVolume(0);
        }else{
            setVolume(getVolume()+1);
        }    
        viewVol();
    }

     //Método para verificar qual o volume 
     public String viewVol() {
        return isPower()? " Volume " + getVolume() : "TV desligada";
    }

     //Método de mudar canais para + 
     public String maisCanais() {
        return executeIfPowered(() -> {
            if (getCanal() == 99) {
                setCanal(0);
            }else{
                setCanal(getCanal()+1);
            } 
        
        return verCanal();
        });
    }

    //Método de mudar canais para -
    public String menosCanais() {
        return executeIfPowered(() -> {
        if (getCanal() == 0) {
            setCanal(99);
        }else{
            setCanal(getCanal()-1);
        }
            return verCanal();
        });
    }   
    
    //Método Realizar mudança de canal diretamente
    public String definirCanal(int Dcanal) {
        return executeIfPowered(() -> {
            setCanal(Dcanal);
            return verCanal();
        });              
    }

    //Métdo para verificar qual o canal 
    public String verCanal(){
         return isPower()? "Canal " + getCanal() : "Tv desligada";
    }

    //métodos de acesso (getter e setter) ao canal
    private int getCanal() {
        if (isPower() == true){
        }return canal;
    }

    private void setCanal(int canal) {
            this.canal = canal;
    }
    
     // Método auxiliar para executar ação se a TV estiver ligada
     protected String executeIfPowered(Supplier<String> action) {
        return isPower() ? action.get() : "TV desligada";
    }

}
