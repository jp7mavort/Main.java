import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Date;

public class CashierFrame extends JFrame {
    private JTextField txtProducto;
    private JTextField txtCantidad;
    private JButton btnComprar;
    private ProductoDAO productoDAO;
    private TransaccionDAO transaccionDAO;
    private String cajero;

    public CashierFrame(String cajero) {
        this.cajero = cajero;
        setTitle("Cashier");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(10, 30, 80, 25);
        add(lblProducto);

        txtProducto = new JTextField();
        txtProducto.setBounds(100, 30, 160, 25);
        add(txtProducto);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 70, 80, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(100, 70, 160, 25);
        add(txtCantidad);

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(100, 110, 160, 25);
        add(btnComprar);

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreProducto = txtProducto.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());

                Document producto = productoDAO.findProductoByNombre(nombreProducto);
                if (producto != null && producto.getInteger("stock") >= cantidad) {
                    double precio = producto.getDouble("precio");
                    double total = precio * cantidad;

                    productoDAO.updateStock(nombreProducto, cantidad);
                    transaccionDAO.insertTransaccion(producto.getObjectId("_id").toString(), cantidad, total, cajero, new Date());
                    new NotaVentaPDF().generarNotaVenta(nombreProducto, cantidad, total, cajero);
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "Stock insuficiente o producto no encontrado.");
                }
            }
        });

        // Conectar a la base de datos
        String uri = "mongodb+srv://jp7mavort:12345@final.012d6.mongodb.net/AutoPartsXpress?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
        productoDAO = new ProductoDAO(database);
        transaccionDAO = new TransaccionDAO(database);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CashierFrame("cajero").setVisible(true);
            }
        });
    }
}
