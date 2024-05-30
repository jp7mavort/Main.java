import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class NotaVentaPDF {
    public void generarNotaVenta(String nombreProducto, int cantidad, double total, String cajero) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("NotaVenta.pdf"));
            document.open();
            document.add(new Paragraph("Nota de Venta"));
            document.add(new Paragraph("Producto: " + nombreProducto));
            document.add(new Paragraph("Cantidad: " + cantidad));
            document.add(new Paragraph("Total: $" + total));
            document.add(new Paragraph("Cajero: " + cajero));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
