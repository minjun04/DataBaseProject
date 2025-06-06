package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.Entity.project.Project;
import DataBaseProject.demo.domain.repository.ProjectRepository;
import DataBaseProject.demo.domain.repository.StudentRepository;
import DataBaseProject.demo.domain.repository.StudyGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddInfoService {
    private final StudyGroupRepository studyGroupRepository;
    private final ProjectRepository projectRepository;
    private final StudentRepository studentRepository;

    //정보조회에서 스터디 그룹 자세히 보기 처리
    public List<StudentStatusResponse> addInfoStudyGroupMember(int groupId){
        StudyGroup studyGroup = studyGroupRepository.findByGroupId(groupId);
        List<Student> studyMember = studentRepository.findByStudyGroup(studyGroup);

        return studyMember.stream()
                .map(member->new StudentStatusResponse(
                        member.getStudentId(),
                        member.getName(),
                        member.getMajor(),
                        member.getGrade(),
                        member.getPhone()
                ))
                .toList();
    }

    //정보조회에서 프로젝트 자세히 보기 처리
    public List<StudentStatusResponse> addInfoProject(String leaderId){
        Project project = projectRepository.findByLeaderId(leaderId);
        List<Student> projectMember =studentRepository.findByProject(project);
        return projectMember.stream()
                .map(member->new StudentStatusResponse(
                        member.getStudentId(),
                        member.getName(),
                        member.getMajor(),
                        member.getGrade(),
                        member.getPhone()
                ))
                .toList();
    }
}
