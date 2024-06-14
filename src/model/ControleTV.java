package model;

import java.util.function.Supplier;

public class ControleTV extends Control{
    private int canal;

     public ControleTV(){
        canal = 10;
    }

     //Botão de power (ligar/desligar)
     public String power() {
        setPower();
        return isPower() ? "Tv Ligada" : "TV Desligada";
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

    //métodos de acesso (getter e setter) ao canal
    private int getCanal() {
        if (isPower() == true){
        }return canal;
    }

    private void setCanal(int canal) {
            this.canal = canal;
    }
    
     // Método auxiliar para executar ação se a TV estiver ligada
     public String executeIfPowered(Supplier<String> action) {
        return isPower() ? action.get() : "TV desligada";
    }

    
    
}
