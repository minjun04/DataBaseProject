package DataBaseProject.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @GetMapping("/index_main")
    public String indexMain() {
        return "index_main";  // Thymeleaf 사용시 확장자 생략 가능
    }
}