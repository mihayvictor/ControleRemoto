package modelo;

public abstract class Controle {

    private int volume;
    private boolean power;

    //Métodos marcados com * geralmente não são encontrados botões em controles

    //Construtor de controle
    public Controle(){
        volume = 10;
        power = false;
    }

    //Botão de power (ligar/desligar)
    public abstract String power();

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

    //Métodos de acesso
    
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

    //métodos de acesso (is e setter) ao power
    public boolean isPower() {
        return this.power;
    }

    protected void setPower() {
        power = !isPower();
        }
}
