package main;
import java.awt.Color;
import java.awt.Dimension;
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
        
        //Configura um titulo para o botão
        setTitle("Controle de TV");

        //Cria o contole
        ControleTV controleTV = new ControleTV();

        //Cria um layout manager
        JPanel painel = new JPanel();
        // Alinhamento vertical dos componentes
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Alinhamento vertical dos componentes

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
        JFrame frame = new JFrame(controleTV.toString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        botaoPower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibe uma mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(frame, controleTV.power());
            }
        });

        //Coloca o botão na da tela 
        painel.add(botaoPower);
        add(painel);

        // JPanel numPainel = new JPanel();
        // painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        
        // for (int i=1; i<=9; i++){
        //     JButton numButton = new JButton(Integer.toString(i));
        //     numButton.setBackground(Color.WHITE);
        //     numButton.setForeground(Color.BLACK);
        //     numButton.addActionListener(isActive(i));
        //     numPainel.add(numButton);
        // }
        // add(numPainel);


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
