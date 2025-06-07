package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ProjectManageController {

    @GetMapping("/projectManage")
    public String projectManage(){
        return "project_manage_member";
    }

}
