package DataBaseProject.demo.controller.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentStatusResponse {

    private String studentId;
    private String name;
    private String major;
    private int grade;
    private String phone;

}
