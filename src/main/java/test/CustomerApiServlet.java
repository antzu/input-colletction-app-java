package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import test.model.Customers;
import test.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/customers")
public class CustomerApiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");
        new ObjectMapper().writeValue(res.getOutputStream(), Customers.getCustomers());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");
        String input = Util.asString(req.getInputStream());
        Person p = new ObjectMapper().readValue(input, Person.class);
        Customers.addCustomer(p);
        new ObjectMapper().writeValue(res.getOutputStream(), p);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customers.clearCustomers();

    }
}
