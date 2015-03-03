package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static demo.Main.contentFromClasspath;

// Extend HttpServlet class
public class Demo extends HttpServlet {

    String defaultFile = "custom-war.xml";
    String NAME = "file";

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();

        String file = request.getParameter(NAME);
        if (file == null) file = defaultFile;

        out.println("<h1>" + contentFromClasspath(Demo.class, "/" + file) + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}
