package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.ProjectResponse;
import DataBaseProject.demo.controller.api.dto.StudentStatusResponse;
import DataBaseProject.demo.controller.api.dto.StudyGroupResponse;
import DataBaseProject.demo.domain.service.MyCheckService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/myStatus")
public class MyStatusCheckApiController {

    private final MyCheckService myCheckService;

    @GetMapping("/info")
    public ResponseEntity<?> myStatusCheck(@RequestParam String studentId){
        StudentStatusResponse response = myCheckService.myStatus(studentId);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/studyInfo")
    public ResponseEntity<?> myStudyGroupCheck(@RequestParam String studentId){

        List<StudyGroupResponse> response = myCheckService.myStudyGroup(studentId);
        System.out.println("스터디 응답: " + response);
        if (response == null) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/projectInfo")
    public ResponseEntity<?> myProjectCheck(@RequestParam String studentId){

        ProjectResponse response = myCheckService.myProject(studentId);
        System.out.println("프로젝트 응답: " + response);
        if (response == null) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(response);
    }

}
