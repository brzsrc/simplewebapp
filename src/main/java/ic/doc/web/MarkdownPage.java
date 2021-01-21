package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.OutputStream;

public class MarkdownPage implements Page {

    private final String query;
    private final String answer;

    public MarkdownPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    public void writeTo(HttpServletResponse resp) throws IOException {
        //File file = new File("result.md");
        //file.createNewFile();
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
            resp.setContentType("text/markdown");
            resp.setHeader("Content-Disposition", "attachment; filename=" + query + ".md");
            
            FileWriter fw = new FileWriter("result.md");
            fw.write("# " + query + "\n" + "- " + answer + "\n");
            fw.close();
            FileInputStream fi = new FileInputStream("result.md");
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
