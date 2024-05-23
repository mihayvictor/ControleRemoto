package modelo;

public class Controle {

    private int volume, canal;
    private boolean power;

    public Controle(){
        volume = 10;
        canal = 10;
        power = false;
    }

    public boolean power() {
        setPower();
        if (power == true) {
            System.out.println("TV ligada");
        }else{
            System.out.println("TV desligada");
        }
        return isPower();
    }

    public void maisCanais() {
        if (getCanal() == 100) {
            setCanal(canal=0);
        }else{
            setCanal(canal+=1);
        } 
        verCanal();
    }

    public void menosCanais() {
        if (getCanal() == 0) {
            setCanal(canal=100);
        }else{
            setCanal(canal-=1);
        }
            verCanal();
        }

    public int definirCanal(int canal) {
            setCanal(canal);
            return verCanal();
    }

    public int verCanal(){
         if (power == true) {
            System.out.println("Canal " + getCanal());
         }return getCanal();
    }

    public void verVolume() {
        getVolume();
    }

    public void definirVolume(int volume) {
        setVolume(volume);
        verVolume();
    }

    public void maisVolume(){
        if (volume < 100) {
            setVolume(volume+=1);
            verVolume();
        }
    }

    public void menosVolume(){
        if (volume > 0) {
            setVolume(volume-=1);
            verVolume();
        }   
    }

    public void mute(){
        if (volume != 0) {
            setVolume(volume=0);
        }else{
            setVolume(getVolume()+1);
        }    
        verVolume();
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
            System.out.println("Volume " + volume);
        }return volume;
    }

    private void setVolume(int volume) {
        if (isPower() == true){
        this.volume = volume;
        }
    }

    private boolean isPower() {
        return this.power;
    }

    private void setPower() {
        power = !isPower();
        }
}
