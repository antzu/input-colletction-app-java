package test;

import test.dao.CustomerDao;
import test.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customers/form")
public class CustomerFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CustomerDao dao = new CustomerDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/x-www-form-urlencoded");

        String input = request.getParameter("name");

        Customer customer = new Customer();
        customer.setFirstName(input);
        dao.insertCustomer(customer);
    }
}