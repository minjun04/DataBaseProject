package DataBaseProject.demo.domain.Entity;

import DataBaseProject.demo.domain.Entity.project.Project;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@IdClass(ProjectApplicationId.class)
@Table(name = "ProjectApplication")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplication {
    @Id
    @Column(name = "application_id")
    private int applicationId;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "project_id", nullable = false)
    private int projectId;

    private String status;

    private LocalDate applicationDate;

    @Column(columnDefinition = "TEXT")
    private String selfIntroduction;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id",
            foreignKey = @ForeignKey(name = "fk_projectapplication_student", foreignKeyDefinition = "FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE"))
    private Student student;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id",
            foreignKey = @ForeignKey(name = "fk_projectapplication_project", foreignKeyDefinition = "FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE"))
    private Project project;


}
