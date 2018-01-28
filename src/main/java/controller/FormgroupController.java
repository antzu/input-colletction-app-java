package controller;

import dao.FormgroupDao;
import model.Formgroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FormgroupController {


    @Resource
    private FormgroupDao dao;

    @GetMapping
    public List<Formgroup> getAllFormGroups() {
        return dao.getAllFormGroups();
    }
}
