package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitialController {



    @GetMapping("/loginAfter")
    public String index(){
        return "loginAfter";
    }

    @GetMapping("/myPage")
    public String myPage(){
        return "mypage";
    }
}
