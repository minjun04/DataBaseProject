package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, String> {
    Project findByLeaderId(String leaderId);
    List<Project> findByTopic(String topic);
}
