package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.ControleTV;

public class TelaControleTV extends JFrame {

    public TelaControleTV(){

        //Verificar porque, mesmo com o pwer desligado ele muda de canal.
        
        //Configura um titulo para o botão
        setTitle("Controle de TV");

        //Cria o contole
        ControleTV controleTV = new ControleTV();

        //Cria um layout manager
        JPanel painel = new JPanel();
        // Alinhamento vertical dos componentes
        

        //Cria o botão de power para o controle
        JButton botaoPower = new JButton("Power");
        botaoPower.setAlignmentX(CENTER_ALIGNMENT);
        botaoPower.setPreferredSize(new Dimension(100, 40));
        // Alinhamento vertical dos componentes
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); 
        botaoPower.setFocusPainted(false);
        botaoPower.setBorderPainted(false); 
        botaoPower.setOpaque(true); 

        
        //Adiciona a ação de ligar/desligar a TV ao botão 
        botaoPower.setBackground(Color.BLACK);
        botaoPower.setForeground(Color.WHITE);
        botaoPower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibe uma mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(null, controleTV.power());
            }
        });

        //Coloca o botão na da tela 
        painel.add(botaoPower);
        

        
        JPanel numPainel = new JPanel();
        numPainel.setLayout( new FlowLayout(FlowLayout.CENTER, 10,10));
        
        for (int i=1; i<=9; i++){
            JButton numButton = new JButton(Integer.toString(i));
            numButton.setBackground(Color.WHITE);
            numButton.setForeground(Color.BLACK);
            final int CANAL = i;
            controleTV.definirCanal(CANAL);
            numButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibe uma mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(null, "Canal: " + CANAL);
                }
            });
            numPainel.add(numButton);
        }
        painel.add(numPainel, BorderLayout.CENTER);

        add(painel, BorderLayout.CENTER);
        //Configura o comportamento de fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        setSize(250, 250);

        // Tornar a janela visível
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
         new TelaControleTV();

    }

    
}
