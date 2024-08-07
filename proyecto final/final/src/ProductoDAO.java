import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

public class ProductoDAO {
    private MongoCollection<Document> productoCollection;

    public ProductoDAO(MongoDatabase database) {
        this.productoCollection = database.getCollection("productos");
    }

    public Document findProductoByNombre(String nombre) {
        return productoCollection.find(Filters.eq("nombre", nombre)).first();
    }

    public UpdateResult updateStock(String nombre, int cantidad) {
        Document producto = findProductoByNombre(nombre);
        if (producto != null) {
            int nuevoStock = producto.getInteger("stock") - cantidad;
            return productoCollection.updateOne(Filters.eq("nombre", nombre), new Document("$set", new Document("stock", nuevoStock)));
        }
        return null;
    }

    public void insertProducto(String nombre, String descripcion, double precio, int stock, String imagen) {
        Document producto = new Document("nombre", nombre)
                .append("descripcion", descripcion)
                .append("precio", precio)
                .append("stock", stock)
                .append("imagen", imagen);
        productoCollection.insertOne(producto);
    }
}
