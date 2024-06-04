package main;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.ControleTV;

public class TelaControleTV extends JFrame {

    public TelaControleTV(){
        
        //Configura um titulo para o botão
        setTitle("Controle de TV");

        //Cria um layout manager
        JPanel painel = new JPanel();
        // Alinhamento vertical dos componentes
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Alinhamento vertical dos componentes

        //Cria o contole
        ControleTV controleTV = new ControleTV();

        //Cria o botão de power para o controle
        JButton botaoPower = new JButton("Power");
        botaoPower.setAlignmentX(CENTER_ALIGNMENT);
        botaoPower.setMaximumSize(new Dimension(120, 40));
        botaoPower.setFocusPainted(false);
        botaoPower.setBorderPainted(false); 
        botaoPower.setOpaque(true); 
        
        //Adiciona a ação de ligar/desligar a TV ao botão 
        botaoPower.setBackground(Color.BLACK);
        botaoPower.setForeground(Color.WHITE);
        botaoPower.addActionListener(e -> System.out.println(controleTV.power()));

        //Coloca o botão na parte superior da tela 
        painel.add(botaoPower);
        add(painel);

        //Configura o comportamento de fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        setSize(400, 400);

        // Tornar a janela visível
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
         new TelaControleTV();

    }

    
}
