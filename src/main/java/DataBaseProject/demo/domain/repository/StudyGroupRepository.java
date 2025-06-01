package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, String> {
    List<StudyGroup> findByStudentId(String studentId);
}
