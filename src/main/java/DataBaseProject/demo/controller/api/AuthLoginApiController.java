package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.domain.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class AuthLoginApiController {

    private final AuthService authService;

    @PostMapping("/templates/login")
    public ResponseEntity<?> authLogin(String studentId) {

        Boolean response = authService.login(studentId);
        return ResponseEntity.ok(response);

    }

}
