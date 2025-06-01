package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.myProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.controller.api.dto.myStudyGroupResponse;
import DataBaseProject.demo.domain.service.MyCheckService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/myStatus")
public class MyStatusCheckController {

    private final MyCheckService myCheckService;

    @GetMapping("/info")
    public ResponseEntity<?> myStatusCheck(String studentId){
        StudentStatusResponse response = myCheckService.myStatus(studentId);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/studyInfo")
    public ResponseEntity<?> myStudyGroupCheck(String studentId){

        List<myStudyGroupResponse> response = myCheckService.myStudyGruop(studentId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/projectInfo")
    public ResponseEntity<?> myProjectCheck(String studentId, String projectName){

        myProjectResponse response = myCheckService.myProject(studentId,projectName);

        return ResponseEntity.ok(response);
    }

}
