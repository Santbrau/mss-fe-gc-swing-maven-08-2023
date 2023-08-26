package ejercicio6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {
    private static JTextField weightField;
    private static JTextField heightField;
    private static JLabel resultLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        JLabel weightLabel = new JLabel("Peso (kg):");
        weightField = new JTextField(10);

        JLabel heightLabel = new JLabel("Altura (m):");
        heightField = new JTextField(10);

        JButton calculateButton = new JButton("Calcular IMC");
        calculateButton.addActionListener(new CalculateButtonListener());

        resultLabel = new JLabel("Resultado");

        // Configuración del diseño
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());

                double bmi = weight / (height * height);

                String category;
                if (bmi < 18.5) {
                    category = "Bajo peso";
                } else if (bmi < 24.9) {
                    category = "Peso normal";
                } else if (bmi < 29.9) {
                    category = "Sobrepeso";
                } else {
                    category = "Obesidad";
                }

                resultLabel.setText("Tu IMC es: " + String.format("%.2f", bmi) + " (" + category + ")");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, ingresa valores válidos.");
            }
        }
    }
}
