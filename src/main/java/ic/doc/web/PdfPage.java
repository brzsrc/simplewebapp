package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.OutputStream;

public class PdfPage implements Page {

    private final String query;
    private final String answer;

    public PdfPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/markdown");
    }
}
