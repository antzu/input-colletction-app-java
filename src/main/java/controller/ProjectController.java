package controller;

import dao.ProjectDao;
import model.Customer;
import model.Project;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProjectController {

    @Resource
    private ProjectDao dao;

    @GetMapping("projects")
    public List<Project> getAllProjects(){
        return dao.getAllProjects();
    }

    @PostMapping("projects")
    public void newProject(@RequestBody Project project) {
        dao.newProject(project);
    }

    @GetMapping("projects/{id}")
    public Project getProject(@PathVariable Long id) {
        return dao.findById(id);
    }

    @PostMapping("projects/{id}")
    public void generateProjectForm(@PathVariable Long id){
        dao.generateProjectForm(id);
    }
}
