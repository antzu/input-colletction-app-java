package test;


import com.fasterxml.jackson.databind.ObjectMapper;
import test.model.Person;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/api/customers")
public class CustomerApiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static ArrayList<Person> personList = new ArrayList<>();



    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");
        new ObjectMapper().writeValue(res.getOutputStream(), personList);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //application/x-www-form-urlencoded
        //application/json
        res.setContentType("application/json");

        if (req.getContentType() == "application/json") {

            String input = Util.asString(req.getInputStream());


            Person p = new ObjectMapper().readValue(input, Person.class);
            System.out.println(p);
            personList.add(p);

            new ObjectMapper().writeValue(res.getOutputStream(), p);

        } else if (req.getContentType() == "application/x-www-form-urlencoded") {

            String input = req.getParameter("name");
            Person p = new Person();
            p.setFirstName(input);
            personList.add(p);

            new ObjectMapper().writeValue(res.getOutputStream(), p);

        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        personList.clear();

    }
}
