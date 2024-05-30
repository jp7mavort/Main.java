import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class AdminFrame extends JFrame {
    private JTextField txtProducto;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtImagen;
    private JButton btnAgregarProducto;
    private JButton btnAgregarCajero;
    private ProductoDAO productoDAO;
    private UserDAO userDAO;

    public AdminFrame() {
        setTitle("Admin");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(10, 30, 80, 25);
        add(lblProducto);

        txtProducto = new JTextField();
        txtProducto.setBounds(100, 30, 160, 25);
        add(txtProducto);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 70, 80, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(100, 70, 160, 25);
        add(txtDescripcion);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(10, 110, 80, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 110, 160, 25);
        add(txtPrecio);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(10, 150, 80, 25);
        add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(100, 150, 160, 25);
        add(txtStock);

        JLabel lblImagen = new JLabel("Imagen URL:");
        lblImagen.setBounds(10, 190, 80, 25);
        add(lblImagen);

        txtImagen = new JTextField();
        txtImagen.setBounds(100, 190, 160, 25);
        add(txtImagen);

        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.setBounds(10, 230, 150, 25);
        add(btnAgregarProducto);

        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtProducto.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());
                String imagen = txtImagen.getText();

                productoDAO.insertProducto(nombre, descripcion, precio, stock, imagen);
                JOptionPane.showMessageDialog(null, "Producto agregado con éxito!");
            }
        });

        btnAgregarCajero = new JButton("Agregar Cajero");
        btnAgregarCajero.setBounds(200, 230, 150, 25);
        add(btnAgregarCajero);

        btnAgregarCajero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Ingrese el nombre del cajero:");
                String password = JOptionPane.showInputDialog("Ingrese la contraseña del cajero:");

                userDAO.insertUser(username, password, "cajero");
                JOptionPane.showMessageDialog(null, "Cajero agregado con éxito!");
            }
        });

        // Conectar a la base de datos
        String uri = "mongodb+srv://jp7mavort:12345@final.012d6.mongodb.net/AutoPartsXpress?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
        productoDAO = new ProductoDAO(database);
        userDAO = new UserDAO(database);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }
}
