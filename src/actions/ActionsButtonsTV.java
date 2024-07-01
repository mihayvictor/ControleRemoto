package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.ControleTV;

    public class ActionsButtonsTV {
        private static int fistDigit = -1;
        private static Timer timer;

            //Cria o contole
            static ControleTV controleTV = new ControleTV();

        //Ação de ligar e desligar a TV
            public static void powerAction(){
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
                numsActions(channel);
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

            numsActions(fullchannel);

            fistDigit = -1;
            if (timer != null) {
                timer.stop();
            }
        }
        }

        //Ação de digitar um número
        public static void numsActions(int channel){
        //Exibe uma mensagem quando o botão é clicado
        JOptionPane.showMessageDialog(null, controleTV.fixChannel(channel));
        }

        //Ação de mostrar a informações
        public static void infoAction(){
        JOptionPane.showMessageDialog(null, controleTV.info());
        }

        //Ação de mudar de canal para +
        public static void channelMore(){
        JOptionPane.showMessageDialog(null, controleTV.moreChannels());
        }

        //Ação de mudar de canal para -
        public static void channelLess(){
        JOptionPane.showMessageDialog(null, controleTV.lessChannels());
        }

        //Ação de aumentar o som
        public static void soundMoreButton(){
        JOptionPane.showMessageDialog(null, controleTV.moreVol());
        }

        //Ação de abaixar o som
        public static void soundLessButton(){
        JOptionPane.showMessageDialog(null, controleTV.lessVol());
        }

        //Ação de mutar a TV
        public static void muteAction(){
        JOptionPane.showMessageDialog(null, controleTV.mute());
        }

    }
