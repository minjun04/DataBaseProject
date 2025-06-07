package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.StudySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<StudySchedule, Integer> {
    StudySchedule findByGroupId(int groupId);

}
