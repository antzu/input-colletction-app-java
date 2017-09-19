package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customers/form")
public class CustomerFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>My HTML Body</h1>");
        out.println("<form action= '/api/customers' method = 'POST' enctype = 'multipart/formdata'>");
        out.println("First name: <input type='text' name='name'><br>");
        out.println("<input type = 'submit' value = 'submit'>");
        out.println("</form>");
        out.println("</body></html>");

    }

}



