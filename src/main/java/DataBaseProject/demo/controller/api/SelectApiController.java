package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.MakeProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudyGroupResponse;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.service.SelectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/select")
public class SelectApiController {

    private final SelectService selectService;

    @GetMapping("/study/topTopic")
    public List<StudyGroupResponse> getStudyGroupsByTopic(@RequestParam String topTopic){
        List<StudyGroupResponse> studyGroups = selectService.getStudyGroupByToptopic(topTopic);
        System.out.println("받은 topic: " + topTopic);
        return studyGroups;
    }


    //스터디 신청과정만 보여주면 될듯

    @GetMapping("/study/topic")
    public List<StudyGroupResponse> getStudyGroupsByToptopic(@RequestParam String topic){
        List<StudyGroupResponse> studyGroups = selectService.getStudyGroupByTopic(topic);
        return studyGroups;
    }

    @GetMapping("/project/topic")
    public List<MakeProjectResponse> getProjectByTopic(@RequestParam String topic){
        List<MakeProjectResponse> projects = selectService.getProjectByTopic(topic);
        return projects;
    }
}
