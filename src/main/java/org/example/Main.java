package org.example;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        OpenHtmlToPdfExample o = new OpenHtmlToPdfExample();
        o.m();
    }
}

class OpenHtmlToPdfExample {
    void m() {
        String html = "<html><head> <style> h1 {color:red;} p {color:blue;} </style> </head><body><h1>Hello, PDF!</h1><p>This is a sample PDF generated with OpenHTMLToPDF.</p></body></html>";
        String pdfPath = "output.pdf";

        try (OutputStream os = new FileOutputStream(pdfPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(os);
            builder.run();
            System.out.println("---------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//https://github.com/danfickle/openhtmltopdf/blob/open-dev-v1/openhtmltopdf-templates/src/main/java/com/openhtmltopdf/templates/PdfCreator.java