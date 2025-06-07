package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, String> {
    List<StudyGroup> findByLeaderId(String studentId);
    StudyGroup findByGroupId(int groupId);
    List<StudyGroup> findByTopTopic(String topTopic);
    List<StudyGroup> findByTopic(String topic);


}
