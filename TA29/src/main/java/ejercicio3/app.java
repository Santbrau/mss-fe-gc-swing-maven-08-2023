package ejercicio3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {
    private static JLabel clickCountLabel1;
    private static JLabel clickCountLabel2;
    private static int button1ClickCount = 0;
    private static int button2ClickCount = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Aplicación de Conteo de Clics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiquetas para mostrar el contador de clics
        clickCountLabel1 = new JLabel("Botón 1 pulsado: 0 veces");
        clickCountLabel2 = new JLabel("Botón 2 pulsado: 0 veces");

        // Botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Agregar ActionListener para los botones
        button1.addActionListener(new ButtonClickListener(1));
        button2.addActionListener(new ButtonClickListener(2));

        // Configuración del diseño
        frame.setLayout(new GridLayout(3, 1));
        frame.add(clickCountLabel1);
        frame.add(clickCountLabel2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame.add(buttonPanel);

        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ActionListener personalizado para actualizar el contador de clics
    private static class ButtonClickListener implements ActionListener {
        private int buttonNumber;

        public ButtonClickListener(int buttonNumber) {
            this.buttonNumber = buttonNumber;
        }

        public void actionPerformed(ActionEvent e) {
            if (buttonNumber == 1) {
                button1ClickCount++;
                clickCountLabel1.setText("Botón 1 pulsado: " + button1ClickCount + " veces");
            } else if (buttonNumber == 2) {
                button2ClickCount++;
                clickCountLabel2.setText("Botón 2 pulsado: " + button2ClickCount + " veces");
            }
        }
    }
}
