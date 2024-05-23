package modelo;

public class Controle {

    private int volume, canal;
    private boolean power;

    //Métodos marcados com * geralmente não são encontrados botões em controles

    //Construtor de controle
    public Controle(){
        volume = 10;
        canal = 10;
        power = false;
    }

    //Botão de power (ligar/desligar)
    public boolean power() {
        setPower();
        if (power == true) {
            System.out.println("TV ligada");
        }else{
            System.out.println("TV desligada");
        }
        return isPower();
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
         if (power == true) {
            System.out.println("Canal " + getCanal());
         }return getCanal();
    }

    //Botão para verificar qual o volume *
    public void verVolume() {
        getVolume();
    }

    //Definir volume diretamente *
    public void definirVolume(int volume) {
        setVolume(volume);
        verVolume();
    }

    //Botão para mudar volume para +
    public void maisVolume(){
        if (volume < 100) {
            setVolume(volume+=1);
            verVolume();
        }
    }

    //Botão para mudar volume para -
    public void menosVolume(){
        if (volume > 0) {
            setVolume(volume-=1);
            verVolume();
        }   
    }

    //Botão mute (colocar e tirar do mudo) 
    public void mute(){
        if (volume != 0) {
            setVolume(volume=0);
        }else{
            setVolume(getVolume()+1);
        }    
        verVolume();
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
    
    //métodos de acesso (getter e setter) ao volume
    private int getVolume() {
        if (isPower() == true){
            System.out.println("Volume " + volume);
        }return volume;
    }
 
    private void setVolume(int volume) {
        if (isPower() == true){
        this.volume = volume;
        }
    }

    //métodos de acesso (is e setter) ao power
    private boolean isPower() {
        return this.power;
    }

    private void setPower() {
        power = !isPower();
        }
}
