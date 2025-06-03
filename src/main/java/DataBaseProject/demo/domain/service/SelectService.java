package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.controller.api.dto.StudyGroupResponse;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.repository.StudyGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SelectService {

    private final StudyGroupRepository studyGroupRepository;

    //큰 토픽에 따른 스터디 그룹 서칭(ex 프로그래밍, 경제학...)
    public List<StudyGroupResponse> getStudyGroupByTopTopic(String topTopic){
        List<StudyGroup> studyGroup = studyGroupRepository.findByTopTopic(topTopic);

        return studyGroup.stream()
                .map(group-> new StudyGroupResponse(
                        group.getGroupId(),
                        group.getGroupName(),
                        group.getActivityDay(),
                        group.getActivityTime(),
                        group.getTopic(),
                        group.getMaxMember()
                ))
                .toList();

    }

    //작은 토픽에 따른 스터디 그룹 서칭(ex 객체지향, C언어...)
    public List<StudyGroupResponse> getStudyGroupByTopic(String topic){
        List<StudyGroup> studyGroup = studyGroupRepository.findByTopic(topic);

        return studyGroup.stream()
                .map(group-> new StudyGroupResponse(
                        group.getGroupId(),
                        group.getGroupName(),
                        group.getActivityDay(),
                        group.getActivityTime(),
                        group.getTopic(),
                        group.getMaxMember()
                ))
                .toList();

    }



}
