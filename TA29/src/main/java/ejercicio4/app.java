package ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class app {
    private static JTextArea eventTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Aplicación de Eventos de Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiqueta y área de texto
        JLabel label = new JLabel("Eventos:");
        eventTextArea = new JTextArea();
        eventTextArea.setEditable(false); 

        // Agregar un WindowListener a la ventana
        frame.addWindowListener(new CustomWindowListener());

        // Configuración del diseño
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // WindowListener personalizado para manejar los eventos de ventana
    private static class CustomWindowListener implements WindowListener {
        public void windowOpened(WindowEvent e) {
            appendToTextArea("Ventana abierta");
        }

        public void windowClosing(WindowEvent e) {
            appendToTextArea("Ventana cerrándose");
        }

        public void windowClosed(WindowEvent e) {
            appendToTextArea("Ventana cerrada");
        }

        public void windowIconified(WindowEvent e) {
            appendToTextArea("Ventana minimizada");
        }

        public void windowDeiconified(WindowEvent e) {
            appendToTextArea("Ventana restaurada");
        }

        public void windowActivated(WindowEvent e) {
            appendToTextArea("Ventana activada");
        }

        public void windowDeactivated(WindowEvent e) {
            appendToTextArea("Ventana desactivada");
        }
    }

    // Método para agregar texto al área de texto
    private static void appendToTextArea(String text) {
        eventTextArea.append(text + "\n");
    }
}
