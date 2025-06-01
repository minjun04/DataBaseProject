package DataBaseProject.demo.domain.Entity.studyRoom;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name="StudyRoom")
public class StudyRoom {

    @Id
    @Column(name="buildingName",nullable = false)
    private String buildingName;

    @Id
    @Column(name ="roomNumber",nullable = false)
    private String roomNumber;

    private int groupId;

    private int capacity;

    private String availableTime;

    private String status;

    /*
    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "groupId",
            foreignKey = @ForeignKey(name = "fk_studyRoom_studyGroup", foreignKeyDefinition = "FOREIGN KEY (groupId) REFERENCES studyGroup(groupId) ON DELETE CASCADE"))
    private StudyGroup group;
    */

}
