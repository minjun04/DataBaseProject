package DataBaseProject.demo.controller.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class myProjectResponse {

    private String name;
    private LocalDate createDate;
    private String topic;
    private int personnel;
}
