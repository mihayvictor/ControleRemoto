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
 
        //Criando panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                
        //Painel de Power
        JPanel powerPanel = new JPanel();
        layoutPanel(powerPanel);

        //Cria o botão de power para o controle e define dimensões
        JButton botaoPower = new JButton("Power");
        botaoPower.setFocusPainted(false);

        //Adiciona a ação de ligar/desligar a TV ao botão 
        botaoPower.setBackground(Color.BLACK);
        botaoPower.setForeground(Color.WHITE);
        botaoPower.addActionListener(new ActionListener() {   
            public void actionPerformed(ActionEvent e) {
                ActionsButtonsTV.actionPower();
            }
        });
        powerPanel.add(botaoPower);

        //Coloca o Painel de power na da tela 
        panel.add(powerPanel);
        space(panel);
        
        //Cria um panel para os botões numericos
        JPanel numPainel = new JPanel();
        numPainel.setLayout(new GridLayout(5, 5, 10, 10));
        // 10px de espaço entre botões

        //Cria 9 botões númericos
        for (int i=0; i<=9; i++){
            JButton numButton = new JButton(Integer.toString(i));
            colorButton(numButton);
            final int CANAL = i;
            numButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActionsButtonsTV.buttonPressed(CANAL);
                }
            });
            numPainel.add(numButton);
        }

        //Adiciona o panel númerico ao panel princial
        panel.add(numPainel);
        space(panel);

        //Cria painel para os botões de mais e menos canais
        JPanel moreLessPanel = new JPanel();
        layoutPanel(moreLessPanel);

        JButton channelMore = new JButton("CH +");
        colorButton(channelMore);
        channelMore.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.channelMore();
            }
        });
        moreLessPanel.add(channelMore);

        JButton channelLess = new JButton("CH -");
        colorButton(channelLess);
        channelLess.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.channelLess();
            }
        });
        moreLessPanel.add(channelLess);

        panel.add(moreLessPanel);
        space(panel);

        //Criando painel para os botões de som
        JPanel soundPanel = new JPanel();
        layoutPanel(soundPanel);
        
        JButton soundMoreButton = new JButton("Vol +");
        colorButton(soundMoreButton);
        soundMoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.soundMoreButton();
            }
        });
        soundPanel.add(soundMoreButton);

        JButton soundLessButton = new JButton("Vol -");
        colorButton(soundLessButton);
        soundLessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ActionsButtonsTV.soundLessButton();
            }
        });
        soundPanel.add(soundLessButton);

        panel.add(soundPanel);

        //Adiciona o panel principal a janela
        add(panel, BorderLayout.CENTER);

        //Configura o comportamento de fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        setSize(250, 300);

        // Tornar a janela visível
        setVisible(true);
    }

    private static void colorButton (JButton button){
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
    }

    private static void layoutPanel(JPanel jPanel){
        jPanel.setLayout(new GridLayout(1, 2, 10, 10));
    }
    
    private static void space(JPanel jPanel){
        jPanel.add(Box.createRigidArea(new Dimension(0,10)));
    }

    
}
