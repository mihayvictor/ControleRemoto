package interfaces;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import actions.ActionsButtons;


public class InterfaceControlTV extends JFrame {

    public InterfaceControlTV(){
        
        //Configura um titulo para o botão
        setTitle("Controle de TV");
 
        //Cria um painel
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); 
        
        //Cria o botão de power para o controle e define dimensões
        JButton botaoPower = new JButton("Power");
        botaoPower.setAlignmentX(CENTER_ALIGNMENT);
        botaoPower.setPreferredSize(new Dimension(100, 40));
        botaoPower.setFocusPainted(false);
        botaoPower.setBorderPainted(false); 
        botaoPower.setOpaque(true); 

        //Adiciona a ação de ligar/desligar a TV ao botão 
        botaoPower.setBackground(Color.BLACK);
        botaoPower.setForeground(Color.WHITE);
        botaoPower.addActionListener(new ActionListener() {   
            public void actionPerformed(ActionEvent e) {
                ActionsButtons.actionPower();
            }
        });

        //Coloca o botão na da tela 
        painel.add(botaoPower);
        
        //Cria um painel para os botões numericos
        JPanel numPainel = new JPanel();
        numPainel.setLayout(new GridLayout(5, 5, 10, 10));
        // 10px de espaço entre botões

        
        
        //Cria 9 botões númericos
        for (int i=0; i<=9; i++){
            JButton numButton = new JButton(Integer.toString(i));
            numButton.setBackground(Color.WHITE);
            numButton.setForeground(Color.BLACK);
            final int CANAL = i;
            numButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActionsButtons.buttonPressed(CANAL);
                }
            });
            numPainel.add(numButton, BorderLayout.CENTER);
        }

        JPanel moreLessChannel = new JPanel();
        moreLessChannel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton channelMore = new JButton("CH +");
        channelMore.setBackground(Color.WHITE);
        channelMore.setForeground(Color.BLACK);
        moreLessChannel.add(channelMore);

        JButton channelLess = new JButton("CH -");
        channelLess.setBackground(Color.WHITE);
        channelLess.setForeground(Color.BLACK);
        moreLessChannel.add(channelLess);

        //Adiciona o painel númerico ao painel princial
        painel.add(numPainel, BorderLayout.CENTER);
        painel.add(moreLessChannel, BorderLayout.CENTER);
        

        //Adiciona o painel principal a janela
        add(painel, BorderLayout.CENTER);

        //Configura o comportamento de fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        setSize(250, 250);

        // Tornar a janela visível
        setVisible(true);
    }

   

    
}
