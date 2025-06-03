package DataBaseProject.demo.domain.Entity.application;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.project.Project;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "ProjectApplication")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplication {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  applicationId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "name", referencedColumnName = "projectName"),
            @JoinColumn(name = "leader_id", referencedColumnName = "leader_id")
    })
    private Project project;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    private String status;

    private LocalDate applicationDate;

    @Column(columnDefinition = "TEXT")
    private String selfIntroduction;



}
