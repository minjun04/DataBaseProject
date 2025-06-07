package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MakingController {

    @GetMapping("/makeProject")
    public String projectMake(){
        return "project_making";
    }

    @GetMapping("/makeStudyGroup")
    public String groupMake(){
        return "group_making";
    }
}
