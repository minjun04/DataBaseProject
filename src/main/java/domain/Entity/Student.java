package domain.Entity;

import jakarta.persistence.*;
import lombok.*;

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

}



