package edu.learn.mongo.pdf.itext;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfCopy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlToPDF {
    public static void main(String[] args) {
        try {
            Document document = new Document();
            document.addTitle("Hello World");
            DocWriter docWriter = new PdfCopy(document, Files.newOutputStream(Paths.get("D://test.pdf")));
            ((PdfCopy) docWriter).addPage(new Rectangle(800,600),1);
            docWriter.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
