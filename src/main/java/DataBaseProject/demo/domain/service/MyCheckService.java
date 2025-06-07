package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.ProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.controller.api.dto.StudyGroupResponse;
import DataBaseProject.demo.domain.Entity.StudySchedule;
import DataBaseProject.demo.domain.Entity.project.Project;
import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.repository.ProjectRepository;
import DataBaseProject.demo.domain.repository.ScheduleRepository;
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
    private final ScheduleRepository scheduleRepository;
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
    public List<StudyGroupResponse> myStudyGroup(String studentId) {
        // 내가 참여하고 있는 스터디 그룹들 가져오기
        List<StudyGroup> myStudyGroups = studyGroupRepository.findByLeaderId(studentId);

        return myStudyGroups.stream()
                .map(group -> {
                    StudySchedule schedule = scheduleRepository.findByGroupId(group.getGroupId());
                    String location = (schedule != null) ? schedule.getLocation() : null;

                    return new StudyGroupResponse(
                            studentRepository.findByStudentId(group.getLeaderId()).getName(),
                            group.getGroupName(),
                            group.getActivityDay(),
                            group.getActivityTime(),
                            group.getTopic(),
                            group.getMaxMember(),
                            location
                    );
                })
                .toList();
    }


    //나의 프로젝트 조회
    public ProjectResponse myProject(String studentId){
        Project myProject = projectRepository.findByLeaderId(studentId);

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
