package DataBaseProject.demo.domain.Entity;

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

    @Id
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Id
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

}
