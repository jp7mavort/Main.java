import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioHobby extends JFrame {
    private JPanel panel;
    private JLabel hobbyLabel;
    private JLabel descripcionLabel;
    private JButton volverButton;

    public FormularioHobby() {
        setTitle("Hobby");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new JPanel();
        colocarComponentes(panel);
        add(panel);
    }

    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        
        hobbyLabel = new JLabel(new ImageIcon("path/to/rugby.jpg"));
        hobbyLabel.setBounds(10, 10, 360, 200);
        panel.add(hobbyLabel);

        descripcionLabel = new JLabel("<html>Rugby: Un deporte de contacto en el que dos equipos compiten por llevar el balón hasta la línea de ensayo del equipo contrario.</html>");
        descripcionLabel.setBounds(10, 220, 360, 60);
        panel.add(descripcionLabel);

        volverButton = new JButton("Volver");
        volverButton.setBounds(10, 300, 360, 25);
        panel.add(volverButton);

        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormularioBiografia formularioBiografia = new FormularioBiografia();
                formularioBiografia.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        FormularioHobby formularioHobby = new FormularioHobby();
        formularioHobby.setVisible(true);
    }
}
