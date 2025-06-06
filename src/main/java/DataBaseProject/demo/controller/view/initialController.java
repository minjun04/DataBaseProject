package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class initialController {

    @GetMapping("/initial")
    public String index(){
        return "initial";
    }
}
