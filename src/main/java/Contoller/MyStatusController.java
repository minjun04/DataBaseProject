package Contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyStatusController {

    @GetMapping("/status")
    public void getMyStatus(){

    }
}
