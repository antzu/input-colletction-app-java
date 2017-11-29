package test.dao;

import test.domain.Customer;
import test.util.DataSourceProvider;
import test.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {


    public List<Customer> getCustomers() {
        EntityManager em = null;

        try{
            em = JpaUtil.getFactory().createEntityManager();

            TypedQuery<Customer> query = em.createQuery("select distinct c from Customer c left join fetch c.phones", Customer.class);

            return query.getResultList();

        } finally {

            JpaUtil.closeQuietly(em);
        }
    }

    public Customer getCustomer(Long customerId) {

        EntityManager em = null;

        try {

            em = JpaUtil.getFactory().createEntityManager();
            TypedQuery<Customer> query = em.createQuery("select c from Customer c left join fetch c.phones where c.id = :id", Customer.class);
            query.setParameter("id", customerId);
            return query.getSingleResult();

        } finally {

            JpaUtil.closeQuietly(em);

        }
    }


    public void deleteCustomer(Long id) {

        EntityManager em = null;

        try {

            em = JpaUtil.getFactory().createEntityManager();

            em.getTransaction().begin();
            em.remove(em.createQuery("select c from Customer c left join fetch c.phones where c.id = :id", Customer.class)
                    .setParameter("id", id).getSingleResult());
            em.getTransaction().commit();

        } finally {

            JpaUtil.closeQuietly(em);

        }
    }

    public void insertCustomer(Customer customer) {
        EntityManager em = null;

        try {

            em = JpaUtil.getFactory().createEntityManager();

            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();

        } finally {

            JpaUtil.closeQuietly(em);

        }
    }

    public void deleteAllCustomers() {

        EntityManager em = null;

        try {
            em = JpaUtil.getFactory().createEntityManager();

            em.getTransaction().begin();
            em.createQuery("delete from Customer").executeUpdate();
            em.getTransaction().commit();

        } finally {
            JpaUtil.closeQuietly(em);
        }
    }
}


