package model;
public abstract class Control {

    private int volume;
    private boolean power;

 public Control() {
    power = false;
    volume = 10;
 }
    //Métodos abstratos
    //Método de ligar/desligar
    public abstract String power();
    //Método para aumentar volume
    public abstract String moreVol();
    //Método para diminuir o volume
    public abstract String lessVol();
    //Método para ver o volume
    public abstract String viewVol();
    //Método mute
    public abstract String mute();

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
