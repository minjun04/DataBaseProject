package DataBaseProject.demo.domain.Entity.project;

import DataBaseProject.demo.domain.Entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    @JoinColumn(name = "leaderId", referencedColumnName = "studentId")
    private String leaderId;

    private LocalDate createDate;

    private String topic;

    private int personnel; //수용가능한 인원 수

    private List<Student> students;

}
