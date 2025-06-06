package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class studyApplyController {

    @GetMapping("/studyApply")
    public String studyApply(){
        return "study_apply";
    }
}
