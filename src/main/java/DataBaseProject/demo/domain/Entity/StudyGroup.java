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

   @Column(name="leaderId", nullable = false)
    private String leaderId;

    private int maxMember;

    private LocalDate createDate;

    /*
    // 그룹장 (리더) : ManyToOne
    @ManyToOne
    @JoinColumn(name = "leaderId", referencedColumnName = "studentId",
            foreignKey = @ForeignKey(name = "fk_studygroup_student_leader"))
    private Student leader;

    // 스터디원 (멤버) : ManyToMany
    @ManyToMany
    @JoinTable(
            name = "StudyGroup_Member",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"),
            foreignKey = @ForeignKey(name = "fk_studygroup_student_member")

    )
    private List<Student> members;
    */
}
