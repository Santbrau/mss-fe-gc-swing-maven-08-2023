package ejercicio1;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class app {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Evntana Redimensionable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ResizableLabel resizableLabel = new ResizableLabel("Arrastra para cambiar el tamaño");
        frame.add(resizableLabel);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class ResizableLabel extends JLabel {
    private int mouseX, mouseY;

    public ResizableLabel(String text) {
        super(text);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getX() - mouseX;
                int deltaY = e.getY() - mouseY;

                setSize(getWidth() + deltaX, getHeight() + deltaY);
                revalidate();
                repaint();

                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
    }
}
