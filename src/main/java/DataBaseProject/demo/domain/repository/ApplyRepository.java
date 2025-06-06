package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.application.StudyApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<StudyApplication,String> {
    List<StudyApplication> findByStudent(Student student);

}
