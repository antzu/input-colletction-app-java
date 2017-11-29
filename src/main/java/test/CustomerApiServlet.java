package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import test.dao.CustomerDao;
import test.domain.Customer;

import javax.persistence.OneToMany;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");

        if (req.getParameter("id") != null) {
            new ObjectMapper().writeValue(res.getOutputStream(), dao.getCustomer(Long.parseLong(req.getParameter("id"))));
        } else {
            new ObjectMapper().writeValue(res.getOutputStream(), dao.getCustomers());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Customer customer = new ObjectMapper().readValue(req.getInputStream(), Customer.class);

        dao.insertCustomer(customer);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") != null) {
            dao.deleteCustomer(Long.parseLong(req.getParameter("id")));
        } else {
            dao.deleteAllCustomers();
        }

    }
}
