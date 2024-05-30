import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JTextField nombreField;
    private JTextField cedulaField;
    private JTextField edadField;
    private JCheckBox activoCheckBox;
    private JComboBox<String> carreraComboBox;
    private JButton guardarButton;

    public Main() {
        super("Registro de Estudiantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nombreField = new JTextField();
        cedulaField = new JTextField();
        edadField = new JTextField();
        activoCheckBox = new JCheckBox("Activo");
        carreraComboBox = new JComboBox<>(new String[]{"Ingeniería en Sistemas", "Ingeniería Civil", "Medicina", "Derecho"});
        guardarButton = new JButton("Guardar");

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(nombreField);
        panelFormulario.add(new JLabel("Cédula:"));
        panelFormulario.add(cedulaField);
        panelFormulario.add(new JLabel("Edad:"));
        panelFormulario.add(edadField);
        panelFormulario.add(new JLabel("Carrera:"));
        panelFormulario.add(carreraComboBox);
        panelFormulario.add(new JLabel("Estado:"));
        panelFormulario.add(activoCheckBox);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(guardarButton);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String cedula = cedulaField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String carrera = (String) carreraComboBox.getSelectedItem();
                boolean activo = activoCheckBox.isSelected();

                Estudiante estudiante = new Estudiante(nombre, cedula, edad, carrera, activo);
                mostrarMensaje("Estudiante guardado:\n\nNombre: " + estudiante.getNombre() +
                        "\nCédula: " + estudiante.getCedula() +
                        "\nEdad: " + estudiante.getEdad() +
                        "\nCarrera: " + estudiante.getCarrera() +
                        "\nEstado: " + (estudiante.isActivo() ? "Activo" : "Inactivo"));
            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
