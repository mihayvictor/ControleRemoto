package modelo;

public class ControleRadioFM extends Controle {
    private double frequecia;

    public ControleRadioFM(){
        frequecia = 93.1;
    }

    @Override
    public boolean power() {
        setPower();
        if (isPower() == true) {
            System.out.println("Rádio ligada");
        }else{
            System.out.println("Rádio desligada");
        }
        return isPower();
    }

     //Botão de mudar frequência para + 
     public void maisFrequencia() {
        if (getFrequecia() == 108.0) {
            setFrequecia(frequecia=87.5);
        }else{
            setFrequecia(frequecia +=0.1);
        } 
        verFrequecia();
    }

    //Botão de mudar frequência para -
    public void menosFrequecia() {
        if (getFrequecia() == 87.5) {
            setFrequecia(frequecia=108.0);
        }else{
            setFrequecia(frequecia-=0.1);
        }
            verFrequecia();
        }    
    
    //Realizar mudança frequência diretamente
    public double definirCanal(int frequecia) {
            setFrequecia(frequecia);
            return verFrequecia();
    }

    //Botão para verificar qual a frequência *
    public double verFrequecia(){
         if (isPower() == true) {
            System.out.printf("Frequência %.1f %s",getFrequecia(), "MHz\n");
         }return getFrequecia();
    }

      //métodos de acesso (getter e setter) ao canal
      private double getFrequecia() {
        if (isPower() == true){
        }return frequecia;
    }

    private void setFrequecia(double frequecia) {
        if (isPower() == true){
            this.frequecia = frequecia;
        }
    }
    
}
