package controller;

import dao.CustomerDao;
import org.springframework.web.bind.annotation.*;
import dao.CustomerJpaDao;
import model.Customer;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Resource
    private CustomerDao dao;

    @GetMapping("customers")
    public List<Customer> getCustomers(){
        return dao.findAll();
    }

    @GetMapping("customers/{id}")
    public Customer getCustomers(@PathVariable Long id) {
        return dao.findById(id);
    }

    @PostMapping("customers")
    public void saveCustomer(@RequestBody @Valid Customer customer) {
        dao.save(customer);
    }

    @DeleteMapping("customers/{id}")
    public void saveCustomer(@PathVariable Long id) {
        dao.delete(id);
    }

    @GetMapping("customers/search")
    public List<Customer> findCustomer(@RequestParam String key) { return dao.findByKey(key); }

    @DeleteMapping("customers")
    public void deleteAll() { dao.deleteAll(); }
}
