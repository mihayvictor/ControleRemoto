package main;

import modelo.Controle;

public class Main {
    public static void main(String[] args) throws Exception {
        Controle controleTV = new Controle();

        controleTV.definirCanal(13);
        controleTV.power();
        controleTV.verCanal();
        controleTV.definirCanal(2);
        controleTV.maisCanais();
        controleTV.maisCanais();
        controleTV.menosCanais();
        controleTV.power();
    

    }
}
