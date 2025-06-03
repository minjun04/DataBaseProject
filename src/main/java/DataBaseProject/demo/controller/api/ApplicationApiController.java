package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.ApplyStudyGroupResponse;
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
    public boolean studyGroupApply(@RequestBody ApplyStudyGroupResponse response){
        boolean applyStudyGroupResponse = applyService.studyGroupApply(response.getSelfIntroduction(),response.getStudent(),response.getGroupId());

        return applyStudyGroupResponse;
    }


}
