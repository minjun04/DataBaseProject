package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.ProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.controller.api.dto.StudyGroupResponse;
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

    //나의 정보 조회
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

    //나의 스터디 그룹 조회
    public List<StudyGroupResponse> myStudyGruop(String studentId){
        List<StudyGroup> mystudyGroup = studyGroupRepository.findByStudentsStudentId(studentId);

        return mystudyGroup.stream()
                .map(group -> new StudyGroupResponse(
                        studentRepository.findByStudentId(group.getLeaderId()).getName(),
                        group.getGroupName(),
                        group.getActivityDay(),
                        group.getActivityTime(),
                        group.getTopic(),
                        group.getMaxMember()
                ))
                .toList();
    }

    //나의 프로젝트 조회
    public ProjectResponse myProject(String studentId, String projectName){
        Project myProject = projectRepository.findByLeaderIdAndName(studentId, projectName);

        if(myProject==null){
            return null;
        }

        return new ProjectResponse(
                myProject.getName(),
                myProject.getCreateDate(),
                myProject.getTopic(),
                myProject.getPersonNum()
        );

    }

}
