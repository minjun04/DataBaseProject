package DataBaseProject.demo.domain.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Table(name="StudyGroup")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="groupId",nullable = false)
    private int groupId;

    private String groupName;

    private String activityDay;

    private String activityTime;

    private String topic;
    private String topTopic;

    @JoinColumn(name = "studentId", referencedColumnName = "leaderId")
    private String leaderId;

    private int maxMember;

    private LocalDate createDate;

    @ManyToMany(mappedBy = "studyGroup")
    private List<Student> students;

    public StudyGroup(String groupName, String activityDay, String activityTime, String leaderId,String topic, String topTopic, int maxMember, LocalDate createDate){
        this.groupName=groupName;
        this.activityDay=activityDay;
        this.activityTime=activityTime;
        this.leaderId=leaderId;
        this.topic=topic;
        this.topTopic=topTopic;
        this.maxMember=maxMember;
        this.createDate=createDate;
    }
}
