package DataBaseProject.demo.controller.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProjectResponse {

    private String name;
    private LocalDate createDate;
    private String topic;
    private int personnel;
}
