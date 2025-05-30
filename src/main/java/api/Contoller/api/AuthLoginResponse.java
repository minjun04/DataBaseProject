package api.Contoller.api;

import domain.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthLoginResponse {
    private Student student;
}
