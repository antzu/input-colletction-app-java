package dao;

import model.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectJpaDao implements ProjectDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Project> getAllProjects() {
        return em.createQuery("select p from Project p", Project.class)
                .getResultList();
    }
}
