package DataBaseProject.demo.domain.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "StudySchedule")
@NoArgsConstructor
@AllArgsConstructor
public class StudySchedule {
    @Id
    @Column(name = "schedule_id")
    private int scheduleId;

    @Column(name = "location")
    private String location;

    @JoinColumn(name="leader_id",referencedColumnName = "leaderId")  // <-- 여기 수정!!
    private String leaderId;


    @Column(name="group_id")
    private int groupId;

}
