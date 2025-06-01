package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.myProjectResponse;
import DataBaseProject.demo.controller.api.dto.myStatusResponse;
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

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
public class MyCheckService {

    private final StudentRepository studentRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final ProjectRepository projectRepository;

    public myStatusResponse myStatus(String studentId) {

        Student student = studentRepository.findByStudentId(studentId);

        return new myStatusResponse(
                student.getStudentId(),
                student.getName(),
                student.getMajor(),
                student.getGrade(),
                student.getPhone()
        );
    }

    public List<myStudyGroupResponse> myStudyGruop(String studentId){
        List<StudyGroup> mystudyGroup = studyGroupRepository.findByStudentId(studentId);

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
        Project myProject = projectRepository.findByleaderIdAndName(studentId, projectName);

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
