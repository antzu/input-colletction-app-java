package dao;

import model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getAllProjects();

    void newProject(Project project);

    Project findById(Long id);

    void generateProjectForm(Long id);
}
