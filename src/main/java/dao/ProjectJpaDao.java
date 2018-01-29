package dao;

import model.FormgroupClassifiers;
import model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public void generateProjectForm(Long id) {
        //select Formgroup_temp values to list
        List<FormgroupClassifiers> list = em.createQuery("select formgroup from FormgroupClassifiers formgroup", FormgroupClassifiers.class)
            .getResultList();

        System.out.println(list);
        //select Formfield_temp values to list where
        //insert Form:
//        CREATE TABLE Formgroup(
//                id BIGINT NOT NULL PRIMARY KEY,
//                name VARCHAR(255) NOT NULL,
//                projectId BIGINT NOT NULL
//        );
//
//        CREATE TABLE Formfield(
//                id BIGINT NOT NULL PRIMARY KEY,
//                formgroupId BIGINT NOT NULL,
//                name VARCHAR(255) NOT NULL,
//                type VARCHAR (255) NOT NULL
//        );
//
//        CREATE TABLE Formvalue(
//                id BIGINT NOT NULL PRIMARY KEY,
//                formfieldId BIGINT NOT NULL,
//                value VARCHAR (255)
//        );

    }
}
