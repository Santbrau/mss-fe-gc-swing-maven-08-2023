package ta28;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejercicio1 extends JFrame{

	  private JTextField textField;
	    private JButton saludarButton;

	    public ejercicio1() {
	        // Configurar el JFrame
	        setTitle("Saludador Personalizable");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(300, 150);
	        setLocationRelativeTo(null);

	        // Crear componentes
	        textField = new JTextField(15);
	        saludarButton = new JButton("Saludar");

	        // Agregar ActionListener al botón
	        saludarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String nombre = textField.getText();
	                if (!nombre.isEmpty()) {
	                    String mensaje = "¡Hola " + nombre + "!";
	                    JOptionPane.showMessageDialog(ejercicio1.this, mensaje);
	                } else {
	                    JOptionPane.showMessageDialog(ejercicio1.this, "Por favor ingresa un nombre.");
	                }
	            }
	        });

	        // Agregar componentes al JFrame
	        setLayout(new FlowLayout());
	        add(new JLabel("Ingresa tu nombre: "));
	        add(textField);
	        add(saludarButton);

	        // Mostrar el JFrame
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new ejercicio1();
	            }
	        });
	    }
	}