import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioLogin extends JFrame {
    private JPanel panel;
    private JTextField usuarioText;
    private JPasswordField contrasenaText;
    private JButton iniciarSesionButton;

    public FormularioLogin() {
        setTitle("Inicio de Sesión");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new JPanel();
        colocarComponentes(panel);
        add(panel);
    }

    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(10, 20, 80, 25);
        panel.add(usuarioLabel);

        usuarioText = new JTextField(20);
        usuarioText.setBounds(100, 20, 165, 25);
        panel.add(usuarioText);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(10, 50, 80, 25);
        panel.add(contrasenaLabel);

        contrasenaText = new JPasswordField(20);
        contrasenaText.setBounds(100, 50, 165, 25);
        panel.add(contrasenaText);

        iniciarSesionButton = new JButton("Iniciar Sesión");
        iniciarSesionButton.setBounds(10, 80, 255, 25);
        panel.add(iniciarSesionButton);

        iniciarSesionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioText.getText();
                String contrasena = new String(contrasenaText.getPassword());
                if (validarLogin(usuario, contrasena)) {

                    FormularioBiografia formularioBiografia = new FormularioBiografia();
                    formularioBiografia.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas");
                }
            }
        });
    }

    private boolean validarLogin(String usuario, String contrasena) {

        return "Joel".equals(usuario) && "Parra".equals(contrasena);
    }

    public static void main(String[] args) {
        FormularioLogin formularioLogin = new FormularioLogin();
        formularioLogin.setVisible(true);
    }
}
