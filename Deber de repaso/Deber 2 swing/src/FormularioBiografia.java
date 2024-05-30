import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioBiografia extends JFrame {
    private JPanel panel;
    private JLabel biografiaLabel;
    private JLabel fraseLabel;
    private JButton siguienteButton;

    public FormularioBiografia() {
        setTitle("Biografía");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new JPanel();
        colocarComponentes(panel);
        add(panel);
    }

    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        biografiaLabel = new JLabel("<html>Joel Parra<br>Edad: 25<br>Ocupación: Estudiante</html>");
        biografiaLabel.setBounds(10, 10, 260, 50);
        panel.add(biografiaLabel);

        fraseLabel = new JLabel("<html><i>\"La programación orientada a objetos es la clave para crear software modular y reutilizable.\"</i></html>");
        fraseLabel.setBounds(10, 70, 260, 50);
        panel.add(fraseLabel);

        siguienteButton = new JButton("Siguiente");
        siguienteButton.setBounds(10, 130, 255, 25);
        panel.add(siguienteButton);

        siguienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormularioHobby formularioHobby = new FormularioHobby();
                formularioHobby.setVisible(true);
                dispose(); // Cierra la ventana de biografía
            }
        });
    }
}
