package main;

import modelo.Controle;

public class Main {
    public static void main(String[] args) throws Exception {
        Controle controleTV = new Controle();

        controleTV.definirCanal(13);
        controleTV.verCanal();
        controleTV.verVolume();
        controleTV.maisVolume();
        controleTV.menosVolume();
        controleTV.definirVolume(99);
        controleTV.power();
        controleTV.definirVolume(100);
        controleTV.verCanal();
        controleTV.definirCanal(2);
        controleTV.definirCanal(100);
        controleTV.maisCanais();
        controleTV.maisCanais();
        controleTV.menosCanais();
        controleTV.verVolume();
        controleTV.maisVolume();
        controleTV.menosVolume();
        controleTV.mute();
        controleTV.maisVolume();
        controleTV.menosVolume();
        controleTV.power();
    

    }
}
