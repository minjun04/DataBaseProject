package DataBaseProject.demo.controller.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MakeStudyRequest {
    private String studentId;

    private String studyName;
    private String topTopic;
    private String topic;

    private String activityDay;
    private String activityTime;

    private int maxMember;

}
