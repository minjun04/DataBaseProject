package DataBaseProject.demo.domain.repository;

import DataBaseProject.demo.domain.Entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, String> {
    Project findByLeaderIdAndName(String leaderId, String name);

}
