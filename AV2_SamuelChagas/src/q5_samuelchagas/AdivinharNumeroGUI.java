package q5_samuelchagas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AdivinharNumeroGUI {
    private int numeroAleatorio;
    private int tentativas = 0;

    private JFrame frame;
    private JButton[] botoes;
    private JTextField tentativasField;

    public AdivinharNumeroGUI() {
        frame = new JFrame("Adivinhe o Número");
        frame.setLayout(new GridLayout(0, 5));

        Random random = new Random();
        numeroAleatorio = random.nextInt(20) + 1;

        // Inicializar os botões e configurar seus ActionListener
        botoes = new JButton[20];
        for (int i = 0; i < 20; i++) {
            int numero = i + 1;
            botoes[i] = new JButton(Integer.toString(numero));
            botoes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    verificarAdivinhacao(numero);
                }
            });
            frame.add(botoes[i]);
        }

        // Configurar o campo de tentativas
        tentativasField = new JTextField("Tentativa: 1");
        tentativasField.setEditable(false);
        frame.add(tentativasField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void verificarAdivinhacao(int numeroEscolhido) {
        tentativas++;
        tentativasField.setText("Tentativa: " + tentativas);

        if (numeroEscolhido == numeroAleatorio) {
            JOptionPane.showMessageDialog(frame, "Parabéns! Você adivinhou o número " + numeroAleatorio + " em " + tentativas + " tentativas.");
            reiniciarJogo();
        } else {
            if (tentativas < 5) {
                JOptionPane.showMessageDialog(frame, "Tente novamente.");
            } else {
                JOptionPane.showMessageDialog(frame, "Suas 5 tentativas acabaram. O número era " + numeroAleatorio);
                reiniciarJogo();
            }
        }
    }

    private void reiniciarJogo() {
        tentativas = 0;
        tentativasField.setText("Tentativa: 1");
        Random random = new Random();
        numeroAleatorio = random.nextInt(20) + 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdivinharNumeroGUI();
            }
        });
    }
}
