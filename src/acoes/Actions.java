package acoes;

import javax.swing.JOptionPane;

import modelo.ControleTV;

public class Actions {

     //Cria o contole
     ControleTV controleTV = new ControleTV();
    
    public void actionPower(){
        JOptionPane.showMessageDialog(null, controleTV.power());
    }

    public void actionsNums(int canal){
        //Exibe uma mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(null, controleTV.definirCanal(canal));
    }
}
