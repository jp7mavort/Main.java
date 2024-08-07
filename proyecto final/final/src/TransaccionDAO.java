import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date; // Asegúrate de importar java.util.Date

public class TransaccionDAO {
    private MongoCollection<Document> transaccionCollection;

    public TransaccionDAO(MongoDatabase database) {
        this.transaccionCollection = database.getCollection("transacciones");
    }

    public void insertTransaccion(String productoId, int cantidad, double total, String cajero, Date fecha) {
        Document transaccion = new Document("producto_id", productoId)
                .append("cantidad", cantidad)
                .append("total", total)
                .append("cajero", cajero)
                .append("fecha", fecha);
        transaccionCollection.insertOne(transaccion);
    }
}
