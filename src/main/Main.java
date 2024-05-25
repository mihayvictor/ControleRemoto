package main;

import modelo.ControleRadioFM;
import modelo.ControleTV;

public class Main {
    public static void main(String[] args) throws Exception {
        ControleTV controleTV1 = new ControleTV();
        ControleRadioFM controleRadio = new ControleRadioFM();

        controleRadio.verFrequecia();
        controleRadio.verVolume();
        controleRadio.maisVolume();
        controleRadio.power();
        controleRadio.verFrequecia();
        controleRadio.maisFrequencia();
        controleRadio.menosFrequecia();
        controleRadio.power();

        // controleTV1.definirCanal(13);
        // controleTV1.verCanal();
        // controleTV1.verVolume();
        // controleTV1.maisVolume();
        // controleTV1.menosVolume();
        // controleTV1.definirVolume(99);
        // controleTV1.power();
        // controleTV1.definirVolume(100);
        // controleTV1.verCanal();
        // controleTV1.definirCanal(2);
        // controleTV1.definirCanal(100);
        // controleTV1.maisCanais();
        // controleTV1.maisCanais();
        // controleTV1.menosCanais();
        // controleTV1.verVolume();
        // controleTV1.maisVolume();
        // controleTV1.menosVolume();
        // controleTV1.mute();
        // controleTV1.maisVolume();
        // controleTV1.menosVolume();
        // controleTV1.power();
    

    }
}
