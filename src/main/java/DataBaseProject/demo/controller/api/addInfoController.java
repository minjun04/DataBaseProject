package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.domain.service.AddInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/addInfo")
public class addInfoController {

    private final AddInfoService addInfoService;
    @GetMapping("/project")
    public ResponseEntity<?> addInfoProject(int groupId){

        List<StudentStatusResponse> response = addInfoService.addInfoStudyGroupMember(groupId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/StudyGroup")
    public ResponseEntity<?> addInfoStudyGroup(String leaderId, String name){
        List<StudentStatusResponse> response = addInfoService.addInfoProject(leaderId,name);

        return ResponseEntity.ok(response);
    }

}
