package domain.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


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

    @Column(name="leaderId", nullable = false)
    private String leaderId;

    private int maxMember;

    private LocalDate createDate;


    @ManyToMany
    @JoinColumn(name = "leaderId", referencedColumnName = "studentId",
            foreignKey = @ForeignKey(name = "fk_studygroup_student", foreignKeyDefinition = "FOREIGN KEY (leaderId) REFERENCES student(studentId) ON DELETE CASCADE"))
    private Student student;


}
