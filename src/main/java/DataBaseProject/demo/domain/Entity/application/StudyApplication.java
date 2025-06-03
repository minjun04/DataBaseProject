package DataBaseProject.demo.domain.Entity.application;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
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
    @Column(name = "applicationId")
    private Integer applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    private StudyGroup studyGroup;

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

