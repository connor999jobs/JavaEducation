
import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTableExtractor;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.net.URL;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        URL url = Main.class.getClassLoader().getResource("sample.pdf");
        PdfDocument document = new PdfDocument("sample.pdf");
        StringBuilder stringBuilder = new StringBuilder();
        PdfTableExtractor pdfTableExtractor = new PdfTableExtractor(document);
//        PDFTextStripper stripper = new PDFTextStripper();
//        String text = stripper.getText(document);
//        System.out.println(text);
    }
}
