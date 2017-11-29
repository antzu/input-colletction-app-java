package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import test.domain.ClassifierInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/api/classifiers")
public class ClassifierServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        ClassifierInfo classifierInfo = new ClassifierInfo();
        List<String> customerTypes = new ArrayList<>();
        List<String> phoneTypes = new ArrayList<>();

        phoneTypes.addAll(Arrays.asList("phone_type.fixed", "phone_type.mobile"));
        customerTypes.addAll(Arrays.asList("customer_type.private", "customer_type.corporate"));

        classifierInfo.setCustomerTypes(customerTypes);
        classifierInfo.setPhoneTypes(phoneTypes);

        new ObjectMapper().writeValue(resp.getOutputStream(), classifierInfo);
    }
}
