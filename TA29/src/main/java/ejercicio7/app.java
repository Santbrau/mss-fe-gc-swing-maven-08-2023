package ejercicio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {
    private static JTextField valueField;
    private static JTextField resultField;

    private static final double PESETA_TO_EURO_RATE = 0.006;
    private static final double EURO_TO_PESETA_RATE = 166.386;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Conversor de Moneda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        JLabel titleLabel = new JLabel("Conversor de Moneda");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel valueLabel = new JLabel("Valor:");
        valueField = new JTextField(10);

        JButton pesetaToEuroButton = new JButton("Pesetas a Euros");
        pesetaToEuroButton.addActionListener(new ConvertButtonListener(true));

        JButton euroToPesetaButton = new JButton("Euros a Pesetas");
        euroToPesetaButton.addActionListener(new ConvertButtonListener(false));

        resultField = new JTextField(20);
        resultField.setEditable(false);

        // Configuración del diseño
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(valueLabel);
        inputPanel.add(valueField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(pesetaToEuroButton);
        buttonPanel.add(euroToPesetaButton);

        JPanel resultPanel = new JPanel(new FlowLayout());
        resultPanel.add(resultField);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(titleLabel);
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);

        frame.add(mainPanel);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class ConvertButtonListener implements ActionListener {
        private boolean pesetaToEuro;

        public ConvertButtonListener(boolean pesetaToEuro) {
            this.pesetaToEuro = pesetaToEuro;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(valueField.getText());
                double convertedValue;

                if (pesetaToEuro) {
                    convertedValue = amount * PESETA_TO_EURO_RATE;
                    resultField.setText(String.format("%.2f pesetas equivale a %.2f euros.", amount, convertedValue));
                } else {
                    convertedValue = amount * EURO_TO_PESETA_RATE;
                    resultField.setText(String.format("%.2f euros equivale a %.2f pesetas.", amount, convertedValue));
                }
            } catch (NumberFormatException ex) {
                resultField.setText("Por favor, ingresa una cantidad válida.");
            }
        }
    }
}

