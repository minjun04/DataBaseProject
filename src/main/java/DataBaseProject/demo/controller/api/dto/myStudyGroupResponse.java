package DataBaseProject.demo.controller.api.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class myStudyGroupResponse {
    private int groupId;
    private String groupName;
    private String activityDay;
    private String activityTime;
    private String topic;
    private int maxMember;
}
