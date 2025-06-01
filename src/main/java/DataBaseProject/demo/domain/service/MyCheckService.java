package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.myProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.controller.api.dto.myStudyGroupResponse;
import DataBaseProject.demo.domain.Entity.project.Project;
import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.repository.ProjectRepository;
import DataBaseProject.demo.domain.repository.StudentRepository;
import DataBaseProject.demo.domain.repository.StudyGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class MyCheckService {

    private final StudentRepository studentRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final ProjectRepository projectRepository;

    public StudentStatusResponse myStatus(String studentId) {

        Student student = studentRepository.findByStudentId(studentId);

        return new StudentStatusResponse(
                student.getStudentId(),
                student.getName(),
                student.getMajor(),
                student.getGrade(),
                student.getPhone()
        );
    }

    public List<myStudyGroupResponse> myStudyGruop(String studentId){
        List<StudyGroup> mystudyGroup = studyGroupRepository.findByStudentsStudentId(studentId);

        return mystudyGroup.stream()
                .map(group -> new myStudyGroupResponse(
                        group.getGroupId(),
                        group.getGroupName(),
                        group.getActivityDay(),
                        group.getActivityTime(),
                        group.getTopic(),
                        group.getMaxMember()
                ))
                .toList();
    }

    public myProjectResponse myProject(String studentId, String projectName){
        Project myProject = projectRepository.findByLeaderIdAndName(studentId, projectName);

        if(myProject==null){
            return null;
        }

        return new myProjectResponse(
                myProject.getName(),
                myProject.getCreateDate(),
                myProject.getTopic(),
                myProject.getPersonnel()
        );

    }

}
