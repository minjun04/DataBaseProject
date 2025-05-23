package domain.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@Table(name="StudyGroup")
public class StudyGroup {
    private int groupId;
    private String groupName;
    private String activityDay;
    private String activityTime;
    private String topic;
    private String leaderId;
    private int maxMember;
    private LocalDate createDate;

}
