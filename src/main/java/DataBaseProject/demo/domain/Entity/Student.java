package DataBaseProject.demo.domain.Entity;

import DataBaseProject.demo.domain.Entity.project.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name="Student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String major;

    private int grade;

    @Column(nullable = false)
    private String phone;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectName", referencedColumnName = "projectName"),
            @JoinColumn(name = "leader_id", referencedColumnName = "leader_id")
    })
    private Project project;

    @ManyToMany
    @JoinTable(
            name = "Student_StudyGroup",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<StudyGroup> studyGroup;

}



