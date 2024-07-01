package interfacesContols;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import actions.ActionsButtonsTV;

public class InterfaceControlTV extends JFrame {

    public InterfaceControlTV(){
        
        //Configura um titulo para o botão
        setTitle("Controle de TV");
 
        //Cria painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                
        //cria painel de Power
        JPanel powerPanel = new JPanel();
        layoutPanelDefault(powerPanel);

        //Cria o botão de power para o controle e define dimensões
        JButton botaoPower = new JButton("POWER");
        botaoPower.setFocusPainted(false);

        //Adiciona a ação de ligar/desligar a TV ao botão 
        botaoPower.setBackground(Color.BLACK);
        botaoPower.setForeground(Color.WHITE);
        botaoPower.addActionListener(new ActionListener() {   
            public void actionPerformed(ActionEvent e) {
                ActionsButtonsTV.powerAction();
            }
        });

        //Adiciona o botão de paower em seu painel
        powerPanel.add(botaoPower);

        //Coloca o Painel de power no painel principal 
        panel.add(powerPanel);
        space(panel);
        
        //Cria um panel para os botões numericos
        JPanel numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(5, 5, 10, 10));
        // 10px de espaço entre botões

        //Cria 9 botões númericos
        for (int i=0; i<=9; i++){
            JButton numsButton = new JButton(Integer.toString(i));
            colorButtonWB(numsButton);
            final int CHANNEL = i;
            numsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActionsButtonsTV.buttonPressed(CHANNEL);
                }
            });
            numPanel.add(numsButton);
        }

        //Adiciona o panel númerico ao panel princial
        panel.add(numPanel);
        space(panel);

        //Cria painel para os botões de mais e menos canais
        JPanel moreLessChannelPanel = new JPanel();
        layoutPanelDefault(moreLessChannelPanel);

        //cria botão de mudar canal para +
        JButton channelMoreButton = new JButton("CH +");
        colorButtonWB(channelMoreButton);
        channelMoreButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.channelMore();
            }
        });

        //Adiciona o botão de mudar de canal para + ao seu painel
        moreLessChannelPanel.add(channelMoreButton);

        //cria botão de mudar canais para -
        JButton channelLessButton = new JButton("CH -");
        colorButtonWB(channelLessButton);
        channelLessButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.channelLess();
            }
        });
        //Adiciona o botão de mudar de canal para - ao seu painel
        moreLessChannelPanel.add(channelLessButton);

        //Adiciona o painel de mudar canais + e - ao painel principal 
        panel.add(moreLessChannelPanel);
        space(panel);

        //Cria painel para os botões de som
        JPanel soundPanel = new JPanel();
        layoutPanelDefault(soundPanel);
        
        //Cria botão de aumentar o som
        JButton soundMoreButton = new JButton("Vol +");
        colorButtonWB(soundMoreButton);
        soundMoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.soundMoreButton();
            }
        });

        //Adiciona o botão de aumentar o som ao seu painel
        soundPanel.add(soundMoreButton);

        //Cria botão de abaxiar o som
        JButton soundLessButton = new JButton("Vol -");
        colorButtonWB(soundLessButton);
        soundLessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.soundLessButton();
            }
        });
        //Adiciona o botão de abaixar o som ao seu painel
        soundPanel.add(soundLessButton);

        //Adiciona o painel de som ao painel principal
        panel.add(soundPanel);

        space(panel);

        //Cria o painel dos botões de mute e info
        JPanel lastPanel = new JPanel();
        layoutPanelDefault(lastPanel);

        //Cria o botão de mute
        JButton muteButton = new JButton("MUTE");
        colorButtonWB(muteButton);
        muteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.muteAction();
            }
        });
        //Adiciona o botão de mute ao seu painel
        lastPanel.add(muteButton);

        //Cria o botão de informações da TV
        JButton infoButton = new JButton("INFO");
        colorButtonWB(infoButton);
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.infoAction();
            }
        });

        //Adiciona o botão de informações da TV ao seu painel
        lastPanel.add(infoButton);

        //Adiciona o painel de Mute e info ao painel principal
        panel.add(lastPanel);

        //Adiciona o panel principal a janela
        add(panel, BorderLayout.CENTER);

        //Configura o comportamento de fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        setSize(250, 350);

        // Tornar a janela visível
        setVisible(true);
    }

    //Metodo para cor de botão branco com texto em preto
    private static void colorButtonWB (JButton button){
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
    }

    //Método para design parão de painel
    private static void layoutPanelDefault(JPanel jPanel){
        jPanel.setLayout(new GridLayout(1, 2, 10, 10));
    }
    
    //Método para adicionar um espaço em um painel
    private static void space(JPanel jPanel){
        jPanel.add(Box.createRigidArea(new Dimension(0,10)));
    }

    
}
