package controller;

import dao.ProjectDao;
import model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
