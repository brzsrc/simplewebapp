package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.OutputStream;

import java.lang.ProcessBuilder;

public class MarkdownPdfPage implements Page {

    private final String query;
    private final String answer;
    private final String format;

    public MarkdownPdfPage(String query, String answer, String format) {
        this.query = query;
        this.answer = answer;
        this.format = format;
    }

    public void writeTo(HttpServletResponse resp) throws IOException {
        if (answer == null || answer.isEmpty()) {
            resp.setContentType("text/html");

            PrintWriter writer = resp.getWriter();
            // Header
            writer.println("<html>");
            writer.println("<head><title>" + query + "</title></head>");
            writer.println("<body>");
            writer.println("<h1>Sorry</h1>");
            writer.print("<p>Sorry, we didn't understand <em>" + query + "</em></p>");
            // Footer
            writer.println("</body>");
            writer.println("</html>");
        } else {
            FileWriter fw = new FileWriter("result.md");
            fw.write("# " + query + "\n" + "- " + answer + "\n");
            fw.close();
            FileInputStream fi = new FileInputStream("result.md");;
            if (this.format.equals("markdown")) {
                resp.setContentType("text/markdown");
                resp.setHeader("Content-Disposition", "attachment; filename=" + query + ".md");
            } else if (this.format.equals("pdf")) {
                resp.setContentType("application/pdf");
                resp.setHeader("Content-Disposition", "attachment; filename=" + query + ".pdf");
                try {
                    Process process = new ProcessBuilder("pandoc", "result.md", "-o", "result.pdf").start();
                    process.waitFor();
                    fi = new FileInputStream("result.pdf");
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            } else {
                resp.setContentType("text/html");

                PrintWriter writer = resp.getWriter();
                // Header
                writer.println("<html>");
                writer.println("<head><title>" + query + "</title></head>");
                writer.println("<body>");
                writer.println("<h1>Sorry</h1>");
                writer.print("<p>Sorry, the output format is unsupported. <em>" + query + "</em></p>");
                // Footer
                writer.println("</body>");
                writer.println("</html>");
                return;
            }
            
            int size = fi.available();
            resp.setContentLength(size);
            byte data[] = new byte[size];
            fi.read(data);

            OutputStream os = resp.getOutputStream();
            os.write(data);
            os.flush(); 
        }
    }
}
