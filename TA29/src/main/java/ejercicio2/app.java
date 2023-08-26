package ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {
    private static JLabel statusLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Aplicación de Botones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiqueta para mostrar el estado del último botón clicado
        statusLabel = new JLabel("Ningún botón ha sido pulsado");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Agregar ActionListener para los botones
        button1.addActionListener(new ButtonClickListener("Botón 1"));
        button2.addActionListener(new ButtonClickListener("Botón 2"));

        // Configuración del diseño
        frame.setLayout(new BorderLayout());
        frame.add(statusLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ActionListener personalizado para actualizar el estado en la etiqueta
    private static class ButtonClickListener implements ActionListener {
        private String buttonText;

        public ButtonClickListener(String buttonText) {
            this.buttonText = buttonText;
        }

        public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Botón pulsado: " + buttonText);
        }
    }
}
