package controller;

import dao.FormgroupDao;
import dao.ProjectDao;
import model.Formgroup;
import model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FormgroupController {


    @Resource
    private FormgroupDao formdao;


    @GetMapping("forms")
    public List<Formgroup> getAllFormGroups() {
        return formdao.getAllFormGroups();
    }

}
