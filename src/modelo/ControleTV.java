package modelo;

public class ControleTV extends Controle{
    private int canal;

     public ControleTV(){
        canal = 10;
    }

     //Botão de power (ligar/desligar)
     public String power() {
        setPower();
        if (isPower() == true) { 
            return "TV ligada";
        }else{
            return "TV desligada";      
        }
    }

     //Botão de mudar canais para + 
     public String maisCanais() {
        if (getCanal() == 100) {
            setCanal(canal=0);
        }else{
            setCanal(canal+=1);
        } 
        return verCanal();
    }

    //Botão de mudar canais para -
    public String menosCanais() {
        if (getCanal() == 0) {
            setCanal(canal=100);
        }else{
            setCanal(canal-=1);
        }
            return verCanal();
        }    
    
    //Realizar mudança de canal diretamente
    public String definirCanal(int canal) {
            setCanal(canal);
            return verCanal();              
    }

    //Botão para verificar qual o canal *
    public String verCanal(){
         if (isPower() == true) {
            return "Canal " + getCanal();
         }
        return "TV desligada"; 
    }

    //métodos de acesso (getter e setter) ao canal
    private int getCanal() {
        if (isPower() == true){
        }return canal;
    }

    private void setCanal(int canal) {
            this.canal = canal;
    }
    
}
