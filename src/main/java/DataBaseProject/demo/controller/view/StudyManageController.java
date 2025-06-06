package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudyManageController {

    @GetMapping("/studyManage")
    public String studyManage(){
        return "study_manage_reservation";
    }
}
