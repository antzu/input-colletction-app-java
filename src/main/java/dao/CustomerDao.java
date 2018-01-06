package dao;

import model.Customer;

import java.util.List;

public interface CustomerDao {

    void save(Customer customer);

    List<Customer> findAll();

    void delete(Long id);

    void deleteAll();

    Customer findById(Long id);

    List<Customer> findByKey(String key);
}
