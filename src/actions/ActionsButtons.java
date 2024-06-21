package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.ControleTV;

public class ActionsButtons {
private static int fistDigit = -1;
private static Timer timer;

     //Cria o contole
     static ControleTV controleTV = new ControleTV();
    
    public static void actionPower(){
        JOptionPane.showMessageDialog(null, controleTV.power());
    }

    public static void buttonPressed(int channel){
        if (controleTV.isPower() == false) {
            JOptionPane.showMessageDialog(null, "TV desligada");
        }else if(fistDigit ==-1) {
            //Primeiro botão pressionado
            fistDigit = channel;
        
        //Espera pelo segundo digito
        timer = new Timer(2000, new ActionListener() {
           public void actionPerformed(ActionEvent e){
            //Processao primeiro digito
            actionsNums(channel);
            fistDigit = -1;
            timer.stop();
           } 
        });
        timer.setRepeats(false);
        timer.start();
    }else{
        //Segundo botão pressionado
        int secondDigit = channel;
        int fullchannel = fistDigit *10 + secondDigit;

        actionsNums(fullchannel);

        fistDigit = -1;
        if (timer != null) {
            timer.stop();
        }
    }
}

    public static void actionsNums(int channel){
        //Exibe uma mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(null, controleTV.definirCanal(channel));
    }

    public static void channelMore(){
        JOptionPane.showMessageDialog(null, controleTV.maisCanais());
    }

    public static void channelLess(){
        JOptionPane.showMessageDialog(null, controleTV.menosCanais());
    }

}
