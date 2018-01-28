package dao;

import model.Formgroup;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FormgroupJpaDao implements FormgroupDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Formgroup> getAllFormGroups() {
        return em.createQuery("select f from Formgroup f", Formgroup.class)
                .getResultList();
    }
}
