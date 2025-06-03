<<<<<<< HEAD
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "groupId")
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

=======
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "groupId")
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
>>>>>>> 6f7ed1f3ee7070fb6d981d6c68327cea4560c9be
