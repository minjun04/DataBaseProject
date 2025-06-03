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
    @Column(name="leaderId",nullable=false)
    private String leaderId;

    private LocalDate createDate;

    private String topic;

    private int personNum; //수용가능한 인원 수

    @OneToMany(mappedBy = "project")
    private List<Student> students;

    public Project(String name, String leaderId, LocalDate createDate, String topic, int personNum){
        this.name=name;
        this.leaderId=leaderId;
        this.createDate=createDate;
        this.topic=topic;
        this.personNum=personNum;
    }

}
