package DataBaseProject.demo.domain.Entity.project;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@IdClass(ProjectId.class)
@Table(name="Project")
public class Project {
    @Id
    @Column(name="projectName")
    private String name;

    @Id
    @Column(name="leaderId",nullable=false)
    private String leaderId;

    private LocalDate createDate;

    private String topic;

    private int personnel; //수용가능한 인원 수
    /*
    @ManyToOne
    @JoinColumn(
            name = "leaderId",
            referencedColumnName = "studentId",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(
                    name = "fk_project_student",
                    foreignKeyDefinition = "FOREIGN KEY (leaderId) REFERENCES student(studentId) ON DELETE CASCADE"
            )
    )
    private Student leader;
    */
}
