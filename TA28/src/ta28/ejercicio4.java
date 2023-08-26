package ta28;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejercicio4 {

	private JFrame frame;
    private JTextField numField1;
    private JTextField numField2;
    private JTextField resultField;
    private JButton sumButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton exitButton;
    private JButton aboutButton;
    private JLabel numLabel1;
    private JLabel numLabel2;
    private JLabel resultLabel;

    public ejercicio4() {
        frame = new JFrame("Mini Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(5, 2));

        numLabel1 = new JLabel("Número 1:");
        numField1 = new JTextField(10);

        numLabel2 = new JLabel("Número 2:");
        numField2 = new JTextField(10);

        resultLabel = new JLabel("Resultado:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        sumButton = new JButton("Sumar");
        subtractButton = new JButton("Restar");
        multiplyButton = new JButton("Multiplicar");
        divideButton = new JButton("Dividir");
        exitButton = new JButton("Salir");
        aboutButton = new JButton("Acerca de");

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Mini Calculadora v1.0", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(numLabel1);
        frame.add(numField1);
        frame.add(numLabel2);
        frame.add(numField2);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(sumButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(exitButton);
        frame.add(aboutButton);

        frame.setVisible(true);
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0.0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese números válidos en los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ejercicio4();
            }
        });
    }
}
