package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.domain.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class AuthLoginApiController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authLogin(@RequestBody String studentId) {

        Boolean response = authService.login(studentId);

        System.out.println("받은 studentId: " + studentId);

        Map<String, Object> result = new HashMap<>();
        result.put("success", response);
        return ResponseEntity.ok(result);

    }

}
