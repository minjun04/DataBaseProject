package DataBaseProject.demo.domain.Entity;

import domain.Entity.StudyScheduleId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@IdClass(StudyScheduleId.class)
@Table(name = "StudySchedule")
@NoArgsConstructor
@AllArgsConstructor
public class StudySchedule {
    @Id
    @Column(name = "schedule_id")
    private int scheduleId;

    @Id
    @Column(name = "leader_id", nullable = false)
    private String leaderId;

    private String location;

    @ManyToOne
    @JoinColumn(name = "leader_id", referencedColumnName = "student_id",
            foreignKey = @ForeignKey(name = "fk_studyschedule_student", foreignKeyDefinition = "FOREIGN KEY (leader_id) REFERENCES student(student_id) ON DELETE CASCADE"))
    private Student leader;

}
