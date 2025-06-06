package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/make")
public class MakingController {

    @GetMapping("/project")
    public String projectMake(){
        return "project_making";
    }

    @GetMapping("/studyGroup")
    public String groupMake(){
        return "group_making";
    }
}
