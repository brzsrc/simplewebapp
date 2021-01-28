package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexPage implements Page {

    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        // Header
        writer.println("<html>");
        writer.println("<head><title>Welcome</title></head>");
        writer.println("<body>");

        // Content
        writer.println(
                "<h1>Welcome, everyone!!</h1>" +
                "<p>Enter your query in the box below: " +
                "<form>" +
                "<input type=\"text\" name=\"q\" /><br><br>" +
                "<fieldset id=\"radiogroup\">" +
                    "<input type=\"radio\" name=\"format\" value=\"html\"> <label for=\"html\">HTML</label><br>" +
                    "<input type=\"radio\" name=\"format\" value=\"markdown\"> <label for=\"markdown\">Markdown</label><br>" +
                    "<input type=\"radio\" name=\"format\" value=\"pdf\"> <label for=\"pdf\">Pdf</label><br>" +
                "</fieldset>" +
                "<input type=\"submit\">" +
                "</form>" +
                "</p>");

        // Footer
        writer.println("</body>");
        writer.println("</html>");
    }
}
