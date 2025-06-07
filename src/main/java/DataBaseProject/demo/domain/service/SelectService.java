package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.MakeProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudyGroupResponse;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.Entity.project.Project;
import DataBaseProject.demo.domain.repository.ProjectRepository;
import DataBaseProject.demo.domain.repository.ScheduleRepository;
import DataBaseProject.demo.domain.repository.StudentRepository;
import DataBaseProject.demo.domain.repository.StudyGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SelectService {

    private final StudyGroupRepository studyGroupRepository;
    private final ProjectRepository projectRepository;
    private final StudentRepository studentRepository;
    private final ScheduleRepository scheduleRepository;

    public List<StudyGroupResponse> getStudyGroupByToptopic(String topTopic) {
        List<StudyGroup> studyGroups = studyGroupRepository.findByTopTopic(topTopic);

        return studyGroups.stream()
                .map(group -> {
                    var schedule = scheduleRepository.findByGroupId(group.getGroupId());
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

    //작은 토픽에 따른 스터디 그룹 서칭(ex 객체지향, C언어...)
    public List<StudyGroupResponse> getStudyGroupByTopic(String topic){
        List<StudyGroup> studyGroups = studyGroupRepository.findByTopic(topic);

        return studyGroups.stream()
                .map(group -> {
                    var schedule = scheduleRepository.findByGroupId(group.getGroupId());
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
    public List<MakeProjectResponse> getProjectByTopic(String topic){
        List<Project> projects = projectRepository.findByTopic(topic);

        return projects.stream()
                .map(group -> new MakeProjectResponse(
                        studentRepository.findByStudentId(group.getLeaderId()).getName(),
                        group.getName(),
                        group.getTopic(),
                        group.getPersonNum()
                ))
                .toList();
    }



}
