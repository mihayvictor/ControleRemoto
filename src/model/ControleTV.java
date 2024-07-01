package model;

import java.util.function.Supplier;

public class ControleTV implements Control{
    private int canal;
    private int volume;
    private boolean power;
    
     public ControleTV(){
        power = false;
        canal = 10;
        volume = 10;
    }

     //Botão de power (ligar/desligar)
     public String power() {
        setPower();
        return isPower() ? "Tv Ligada" : "TV Desligada";
    }

    //Botão para mudar volume para +
    public String moreVol(){
        return executeIfPowered(() -> {
            if (volume < 100) {
                setVolume(volume+=1);
            }else{
                setVolume(volume = 0);
            }
        
        return viewVol();
        });
    }

    //Botão para mudar volume para -
    public String lessVol(){
        return executeIfPowered(() -> {
        if (volume > 0) {
            setVolume(volume-=1);
        }
        else{
            setVolume(volume = 100);
        }   
        return viewVol();
        });
    }

     //Botão mute (colocar e tirar do mudo) 
     public void mute(){
        if (volume != 0) {
            setVolume(volume=0);
        }else{
            setVolume(getVolume()+1);
        }    
        viewVol();
    }

     //Botão para verificar qual o volume *
     public String viewVol() {
        return isPower()? " Volume " + getVolume() : "TV desligada";
    }

     //Botão de mudar canais para + 
     public String maisCanais() {
        return executeIfPowered(() -> {
            if (getCanal() == 99) {
                setCanal(canal=0);
            }else{
                setCanal(canal+=1);
            } 
        
        return verCanal();
        });
    }

    //Botão de mudar canais para -
    public String menosCanais() {
        return executeIfPowered(() -> {
        if (getCanal() == 0) {
            setCanal(canal=99);
        }else{
            setCanal(canal-=1);
        }
            return verCanal();
        });
    }   
    
    //Realizar mudança de canal diretamente
    public String definirCanal(int canal) {
        return executeIfPowered(() -> {
            setCanal(canal);
            return verCanal();
        });              
    }

    //Botão para verificar qual o canal *
    public String verCanal(){
         return isPower()? "Canal " + getCanal() : "Tv desligada";
    }

    //métodos de acesso (getter e setter) ao volume
    protected int getVolume() {
        if (isPower() == true){
            System.out.println("Volume " + volume);
        }return volume;
    }
 
    protected void setVolume(int volume) {
        if (isPower() == true){
        this.volume = volume;
        }
    }

    //métodos de acesso (getter e setter) ao canal
    private int getCanal() {
        if (isPower() == true){
        }return canal;
    }

    private void setCanal(int canal) {
            this.canal = canal;
    }

    //métodos de acesso (is e setter) ao power
    public boolean isPower() {
        return this.power;
    }

    protected void setPower() {
        power = !isPower();
    }
    
     // Método auxiliar para executar ação se a TV estiver ligada
     protected String executeIfPowered(Supplier<String> action) {
        return isPower() ? action.get() : "TV desligada";
    }

    
    
    
}
