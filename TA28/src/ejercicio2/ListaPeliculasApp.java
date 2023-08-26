package ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListaPeliculasApp {
    private JFrame frame;
    private JComboBox<pelicula> peliculasComboBox;
    private JTextField peliculaTextField;
    private JButton agregarButton;

    private List<pelicula> peliculas;

    public ListaPeliculasApp() {
        peliculas = new ArrayList<>();

        frame = new JFrame("Lista de Películas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        peliculasComboBox = new JComboBox<>();
        peliculaTextField = new JTextField(15);
        agregarButton = new JButton("Añadir");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePelicula = peliculaTextField.getText();
                if (!nombrePelicula.isEmpty()) {
                    pelicula pelicula = new pelicula(nombrePelicula);
                    peliculas.add(pelicula);
                    peliculasComboBox.addItem(pelicula);
                    peliculaTextField.setText("");
                }
            }
        });

        frame.add(new JLabel("Película:"));
        frame.add(peliculaTextField);
        frame.add(agregarButton);
        frame.add(peliculasComboBox);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaPeliculasApp();
            }
        });
    }
}
