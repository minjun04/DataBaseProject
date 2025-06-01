package DataBaseProject.demo.controller.api.dto;

import DataBaseProject.demo.domain.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthLoginResponse {
    private Student student;
}
