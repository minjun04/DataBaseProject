package DataBaseProject.demo.controller.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class studyResponse {
    private String groupName;
    private String activityDay;
    private String activityTime;
    private String location;

}
