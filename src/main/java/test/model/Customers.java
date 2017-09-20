package test.model;

import java.util.ArrayList;
import java.util.List;

public class Customers {

    private static List<Person> customers = new ArrayList<>();

    public static void addCustomer(Person p) { customers.add(p); }

    public static List getCustomers() { return Customers.customers; }

    public static void clearCustomers() { customers.clear(); }

}
