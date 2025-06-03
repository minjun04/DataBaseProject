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

    private List<Student> students;

}
