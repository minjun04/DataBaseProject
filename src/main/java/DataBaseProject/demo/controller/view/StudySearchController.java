package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudySearchController {

    @GetMapping("/studySearch")
    public String studySearch(){

        return "study_search";
    }
    @GetMapping("/projectSearch")
    public String projectSearch(){
        return "blue-search";
    }
}
