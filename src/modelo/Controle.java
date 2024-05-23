package modelo;

public class Controle {

    private int volume, canal;
   
    private boolean power;

    public Controle(){
        volume = 10;
        canal = 10;
        power = false;
    }

    public void power() {
        if (isPower() == false){
            setPower(true);
            System.out.println("TV ligada");
        }else{
            setPower(false);
            System.out.println("TV desligada");
        }
        
    }

    public void maisCanais() {
        if (getCanal() >= 0) {
            setCanal(canal+=1);   
        } verCanal();
    }

    public int menosCanais() {
        if (getCanal() >= 0) {
            setCanal(canal-=1);
        }return verCanal();
        
    }

    public int definirCanal(int mudarCanal) {
            setCanal(mudarCanal);
        return verCanal();
    }

    public int verCanal(){
        System.out.println("Canal " + getCanal());
        return getCanal();   
    }

    public void verVolume() {
        System.out.println("Volume " + getVolume());
    }

    public void definirVolume(int Mudarvolume) {
        setVolume(Mudarvolume);
        System.out.println("Volume " + getVolume());
    }

    private int getCanal() {
        if (isPower() == true){
        }return canal;
    }

    private void setCanal(int canal) {
        if (isPower() == true){
        this.canal = canal;
        }
    }

    private int getVolume() {
        if (isPower() == true){
        }return volume;
    }

    private void setVolume(int volume) {
        if (isPower() == true){
        this.volume = volume;
        }
    }

    private boolean isPower() {
        return power;
        
    }

    private void setPower(boolean power) {
        this.power = power;
    }
    
}
