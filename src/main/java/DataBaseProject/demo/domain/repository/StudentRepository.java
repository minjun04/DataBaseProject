package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudentId(String studentId);

}
