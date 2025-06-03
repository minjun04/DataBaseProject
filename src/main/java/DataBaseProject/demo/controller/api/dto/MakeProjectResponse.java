package DataBaseProject.demo.controller.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MakeProjectResponse {
    private String leaderName;
    private String name;
    private String topic;
    private int personNum;
}
