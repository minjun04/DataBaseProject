package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.ApplyStudyGroupRequest;
import DataBaseProject.demo.domain.Entity.application.StudyApplication;
import DataBaseProject.demo.domain.service.ApplyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApplicationApiController {

    private final ApplyService applyService;

    //신청
    @GetMapping("/apply")
    public boolean studyGroupApply(@RequestBody ApplyStudyGroupRequest request){
        boolean applyStudyGroupResponse = applyService.studyGroupApply(request.getSelfIntroduction(),request.getStudentId(),request.getGroupId());

        return applyStudyGroupResponse;
    }
    
    @GetMapping("/accept")
    public boolean studyGroupAccept(StudyApplication studyApplication){
        return applyService.applyAccept(studyApplication);
    }

    @GetMapping("/refuse")
    public boolean studyGroupRefuse(StudyApplication studyApplication){
        return applyService.applyRefuse(studyApplication);
    }
}
