package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthLoginController {


    @GetMapping("/login")
    public String AuthLogin(){
        return "login";
    }
}
