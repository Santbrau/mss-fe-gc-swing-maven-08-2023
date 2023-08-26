package ta28;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejercicio3 {

	 private JFrame frame;
	    private JRadioButton windowsRadioButton;
	    private JRadioButton linuxRadioButton;
	    private JRadioButton macRadioButton;
	    private JCheckBox programacionCheckBox;
	    private JCheckBox disenoGraficoCheckBox;
	    private JCheckBox administracionCheckBox;
	    private JSlider horasDedicadasSlider;
	    private JButton mostrarDatosButton;

	    public ejercicio3() {
	        frame = new JFrame("Mini Encuesta");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 500);
	        frame.setLayout(new GridLayout(6, 1));

	        // Pregunta 1: Sistema Operativo
	        JPanel sistemaOperativoPanel = new JPanel();
	        sistemaOperativoPanel.setBorder(BorderFactory.createTitledBorder("Elige un sistema operativo"));
	        windowsRadioButton = new JRadioButton("Windows");
	        linuxRadioButton = new JRadioButton("Linux");
	        macRadioButton = new JRadioButton("Mac");

	        ButtonGroup sistemaOperativoGroup = new ButtonGroup();
	        sistemaOperativoGroup.add(windowsRadioButton);
	        sistemaOperativoGroup.add(linuxRadioButton);
	        sistemaOperativoGroup.add(macRadioButton);

	        sistemaOperativoPanel.add(windowsRadioButton);
	        sistemaOperativoPanel.add(linuxRadioButton);
	        sistemaOperativoPanel.add(macRadioButton);

	        frame.add(sistemaOperativoPanel);

	        // Pregunta 2: Especialidades
	        JPanel especialidadesPanel = new JPanel();
	        especialidadesPanel.setBorder(BorderFactory.createTitledBorder("Elige tu especialidad"));
	        programacionCheckBox = new JCheckBox("Programación");
	        disenoGraficoCheckBox = new JCheckBox("Diseño Gráfico");
	        administracionCheckBox = new JCheckBox("Administración");

	        especialidadesPanel.add(programacionCheckBox);
	        especialidadesPanel.add(disenoGraficoCheckBox);
	        especialidadesPanel.add(administracionCheckBox);

	        frame.add(especialidadesPanel);

	        // Pregunta 3: Horas Dedicadas
	        JPanel horasDedicadasPanel = new JPanel();
	        horasDedicadasPanel.setBorder(BorderFactory.createTitledBorder("Horas dedicadas en el ordenador"));
	        horasDedicadasSlider = new JSlider(0, 10);
	        horasDedicadasSlider.setMajorTickSpacing(1);
	        horasDedicadasSlider.setPaintTicks(true);
	        horasDedicadasSlider.setPaintLabels(true);

	        horasDedicadasPanel.add(horasDedicadasSlider);

	        frame.add(horasDedicadasPanel);

	        // Botón Mostrar Datos
	        mostrarDatosButton = new JButton("Mostrar Datos");
	        mostrarDatosButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String sistemaOperativo = windowsRadioButton.isSelected() ? "Windows" :
	                                          linuxRadioButton.isSelected() ? "Linux" :
	                                          macRadioButton.isSelected() ? "Mac" : "Ninguno";

	                StringBuilder especialidades = new StringBuilder();
	                if (programacionCheckBox.isSelected()) {
	                    especialidades.append("Programación, ");
	                }
	                if (disenoGraficoCheckBox.isSelected()) {
	                    especialidades.append("Diseño Gráfico, ");
	                }
	                if (administracionCheckBox.isSelected()) {
	                    especialidades.append("Administración, ");
	                }
	                if (especialidades.length() > 0) {
	                    especialidades.setLength(especialidades.length() - 2); 
	                } else {
	                    especialidades.append("Ninguna");
	                }

	                int horasDedicadas = horasDedicadasSlider.getValue();

	                String mensaje = "Sistema Operativo: " + sistemaOperativo + "\n" +
	                                 "Especialidades: " + especialidades + "\n" +
	                                 "Horas Dedicadas: " + horasDedicadas;

	                JOptionPane.showMessageDialog(frame, mensaje);
	            }
	        });

	        frame.add(mostrarDatosButton);

	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new ejercicio3();
	            }
	        });
	    }
	}