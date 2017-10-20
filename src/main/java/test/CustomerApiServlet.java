package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import test.dao.CustomerDao;
import test.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/customers")
public class CustomerApiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CustomerDao dao = new CustomerDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");

        if(req.getParameter("id") != null) {
            Long id = Long.parseLong(req.getParameter("id"));
            new ObjectMapper().writeValue(res.getOutputStream(), dao.getCustomer(id));
        } else {
            new ObjectMapper().writeValue(res.getOutputStream(), dao.getCustomers());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

            String input = Util.asString(req.getInputStream());
            Customer customer = new ObjectMapper().readValue(input, Customer.class);

            dao.insertCustomer(customer);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("id") != null) {
            Long id = Long.parseLong(req.getParameter("id"));
            dao.deleteCustomer(id);
        } else {
            dao.deleteAllCustomers();
        }

    }
}
