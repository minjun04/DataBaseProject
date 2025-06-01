package DataBaseProject.demo.controller.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class myStatusResponse {

    private String studentId;
    private String name;
    private String major;
    private int grade;
    private String phone;

}
