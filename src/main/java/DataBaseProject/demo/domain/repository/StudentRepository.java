package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.Entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudentId(String studentId);
    List<Student> findByProject(Project project);
    List<Student> findByStudyGroup(StudyGroup studygroup);
}
