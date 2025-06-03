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
    @Column(name = "studentId", nullable = false)
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
            @JoinColumn(name = "leaderId", referencedColumnName = "leaderId")
    })
    private Project project;

    @ManyToMany
    @JoinTable(
            name = "Student_StudyGroup",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "groupId")
    )
    private List<StudyGroup> studyGroup;

}



