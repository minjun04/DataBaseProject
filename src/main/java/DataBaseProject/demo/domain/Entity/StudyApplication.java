package DataBaseProject.demo.domain.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "StudyApplication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name="student_Id",nullable=false)
    private String studentId;

    @Column(name="group_Id",nullable=false)
    private String groupId;

    @Column(name = "status")
    private String status;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "self_introduction", columnDefinition = "TEXT")
    private String selfIntroduction;

    @Builder
    public StudyApplication(Student student, StudyGroup studyGroup, String status, LocalDate applicationDate, String selfInfo) {
        this.student=student;
        this.studyGroup=studyGroup;
        this.status=status;
        this.applicationDate= applicationDate;
        this.selfIntroduction=selfInfo;
    }
}

