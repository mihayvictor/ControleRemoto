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
import javax.swing.JPanel;
import acoes.Actions;


public class TelaControleTV extends JFrame {

    public TelaControleTV(){
        
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
                Actions.actionPower();
            }
        });

        //Coloca o botão na da tela 
        painel.add(botaoPower);
        
        //Cria um painel para os botões numericos
        JPanel numPainel = new JPanel();
        numPainel.setLayout( new FlowLayout(FlowLayout.CENTER, 10,10));
        
        //Cria 9 botões númericos
        for (int i=0; i<=9; i++){
            JButton numButton = new JButton(Integer.toString(i));
            numButton.setBackground(Color.WHITE);
            numButton.setForeground(Color.BLACK);
            final int CANAL = i;
            numButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Actions.buttonPressed(CANAL);
                }
            });
            numPainel.add(numButton);
        }

    

        //Adiciona o painel númerico ao painel princial
        painel.add(numPainel, BorderLayout.CENTER);

        //Adiciona o painel principal a janela
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
