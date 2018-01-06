package dao;

import model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerJpaDao implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Customer customer) {
        if (customer.getId() == null) {
            em.persist(customer);
        } else {
            em.merge(customer);
        }
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select distinct c from Customer c left join fetch c.phones", Customer.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        em.remove(em.createQuery("select c from Customer c left join fetch c.phones where c.id = :id", Customer.class)
                .setParameter("id", id)
                .getSingleResult());
    }

    @Override
    @Transactional
    public void deleteAll() {

        em.createQuery("delete from Customer")
                .executeUpdate();

    }

    @Override
    public Customer findById(Long id) {

        return em.createQuery("select c from Customer c left join fetch c.phones where c.id = :id", Customer.class)
                .setParameter("id", id).getSingleResult();

    }

    @Override
    public List<Customer> findByKey(String key) {
        return em.createQuery("select distinct c from Customer c " +
                "left join fetch c.phones " +
                "where UPPER(c.firstName) like UPPER(:key)" +
                "or UPPER(c.lastName) like UPPER(:key) " +
                "or UPPER(c.code) like UPPER(:key) ", Customer.class)
                .setParameter("key", "%"+key+"%")
                .getResultList();
    }
}


