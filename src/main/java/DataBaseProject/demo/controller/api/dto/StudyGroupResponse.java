package DataBaseProject.demo.controller.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudyGroupResponse {
    private String leaderName;
    private String groupName;
    private String activityDay;
    private String activityTime;
    private String topic;
    private int maxMember;
    private String location;
}
