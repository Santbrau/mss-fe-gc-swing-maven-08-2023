package ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class app {
    private static JTextArea eventTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Aplicación de Eventos de Ratón");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Área de texto para mostrar los eventos de ratón
        eventTextArea = new JTextArea();
        eventTextArea.setEditable(false); 

        // Agregar un MouseListener al área de texto
        eventTextArea.addMouseListener(new CustomMouseListener());

        // Botón para limpiar el área de texto
        JButton clearButton = new JButton("Limpiar");
        clearButton.addActionListener(e -> eventTextArea.setText(""));

        // Panel para el botón
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(clearButton);

        // Configuración del diseño
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // MouseListener personalizado para manejar los eventos de ratón
    private static class CustomMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            appendToTextArea("Clic en (" + e.getX() + ", " + e.getY() + ")");
        }

        public void mouseEntered(MouseEvent e) {
            appendToTextArea("Ratón entrando en el área");
        }

        public void mouseExited(MouseEvent e) {
            appendToTextArea("Ratón saliendo del área");
        }

        public void mousePressed(MouseEvent e) {
            appendToTextArea("Botón del ratón presionado");
        }

        public void mouseReleased(MouseEvent e) {
            appendToTextArea("Botón del ratón liberado");
        }
    }

    // Método para agregar texto al área de texto
    private static void appendToTextArea(String text) {
        eventTextArea.append(text + "\n");
    }
}
