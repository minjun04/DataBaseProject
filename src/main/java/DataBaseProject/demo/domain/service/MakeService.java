package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.MakeProjectRequest;
import DataBaseProject.demo.controller.api.dto.MakeStudyRequest;
import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.Entity.project.Project;
import DataBaseProject.demo.domain.repository.ProjectRepository;
import DataBaseProject.demo.domain.repository.StudentRepository;
import DataBaseProject.demo.domain.repository.StudyGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MakeService {

    private final StudentRepository studentRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final ProjectRepository projectRepository;
    //변수가 너무 많아서 그냥 Dto 씀 원래는 이런 구조면 안좋음
    public boolean makeMyStudyGroup(MakeStudyRequest request){
        Student student =studentRepository.findByStudentId(request.getStudentId());

        StudyGroup studyGroup =new StudyGroup(
                request.getStudyName(),
                request.getActivityDay(),
                request.getActivityTime(),
                student.getStudentId(),
                request.getTopic(),
                request.getTopTopic(),
                request.getMaxMember(),
                LocalDate.now()
        );

        studyGroupRepository.save(studyGroup);

        return true;
    }

    public boolean makeMyProject(MakeProjectRequest request){
        Student student =studentRepository.findByStudentId(request.getStudentId());

        Project project = new Project(
                request.getName(),
                student.getStudentId(),
                LocalDate.now(),
                request.getTopic(),
                request.getPersonNum()
        );

        projectRepository.save(project);

        return true;
    }


}
