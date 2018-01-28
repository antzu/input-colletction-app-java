package dao;

import model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
        public void newProject(Project project) {
            if (project.getId() == null){
                em.persist(project);
            } else {
                em.merge(project);
            }
    }

    @Override
    public Project findById(Long id) {
        return em.createQuery("select p from Project p where p.id = :id", Project.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
