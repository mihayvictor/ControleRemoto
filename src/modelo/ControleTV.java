package modelo;

public class ControleTV extends Controle{
    private int canal;

     public ControleTV(){
        canal = 10;
    }

     //Botão de power (ligar/desligar)
     public String power() {
        String a;
        setPower();
        if (isPower() == true) {
            return a = "TV ligada";
        }else{
            return a = "TV desligada";      
        }
        
    }

     //Botão de mudar canais para + 
     public void maisCanais() {
        if (getCanal() == 100) {
            setCanal(canal=0);
        }else{
            setCanal(canal+=1);
        } 
        verCanal();
    }

    //Botão de mudar canais para -
    public void menosCanais() {
        if (getCanal() == 0) {
            setCanal(canal=100);
        }else{
            setCanal(canal-=1);
        }
            verCanal();
        }    
    
    //Realizar mudança de canal diretamente
    public int definirCanal(int canal) {
            setCanal(canal);
            return verCanal();
    }

    //Botão para verificar qual o canal *
    public int verCanal(){
         if (isPower() == true) {
            System.out.println("Canal " + getCanal());
         }return getCanal();
    }

    //métodos de acesso (getter e setter) ao canal
    private int getCanal() {
        if (isPower() == true){
        }return canal;
    }

    private void setCanal(int canal) {
        if (isPower() == true){
            this.canal = canal;
        }
    }

}
