package test.dao;

import test.model.Customer;
import test.util.DataSourceProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {


    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();


        try (Connection conn = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = conn.createStatement()) {

            try (ResultSet r = stmt.executeQuery("select * from customers")) {
                while (r.next()) {
                    customers.add(new Customer(r.getLong(1),r.getString(2), r.getString(3), r.getString(4)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customers;
    }

    public Customer getCustomer(Long customerId) {

        Customer customer = new Customer();
        String query = "select * from customers where id = ?";

        try (Connection conn = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, customerId);


            try (ResultSet r = ps.executeQuery()) {
                while (r.next()) {
                    customer.setId(r.getLong(1));
                    customer.setFirstName(r.getString(2));
                    customer.setLastName(r.getString(3));
                    customer.setCode(r.getString(4));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }


    public void deleteCustomer(Long id) {

        String query = "delete from customers where id = ?";

        try (Connection conn = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCustomer(Customer customer) {
        try (Connection conn = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "   INSERT INTO CUSTOMERS (id, firstName, lastName, code) VALUES (NEXT VALUE FOR seq1, ?, ?, ?)")) {

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getCode());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAllCustomers() {

        String query = "delete from customers";

        try (Connection conn = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


