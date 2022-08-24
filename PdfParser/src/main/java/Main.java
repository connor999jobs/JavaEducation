import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import lombok.SneakyThrows;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        URL url = Main.class.getClassLoader().getResource("sample.pdf");
        File file = new File(url.toURI());

        PdfDocument document = new PdfDocument();
        document.loadFromBytes(Files.readAllBytes(file.toPath()));

        StringBuilder stringBuilder = new StringBuilder();
        PdfTableExtractor pdfTableExtractor = new PdfTableExtractor(document);


        for (int pageIndex = 0; pageIndex < document.getPages().getCount(); pageIndex++) {
            PdfTable[] tableLists = pdfTableExtractor.extractTable(pageIndex);

            if (tableLists != null && tableLists.length > 0) {
                for (PdfTable table : tableLists) {
                    for (int i = 0; i < table.getRowCount(); i++) {
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            String text = table.getText(i, j);
                            stringBuilder.append(text + " | ");
                        }
                        stringBuilder.append("\r\n");
                    }
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
