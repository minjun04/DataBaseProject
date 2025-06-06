package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.MakeProjectRequest;
import DataBaseProject.demo.controller.api.dto.MakeStudyRequest;
import DataBaseProject.demo.domain.service.MakeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/make")
public class MakingApiController {

   private final MakeService makeService;

    @PostMapping("/study")
    public ResponseEntity<?> makeStudyGroup(@RequestBody MakeStudyRequest request){
        boolean response = makeService.makeMyStudyGroup(request);
        Map<String, Object> result = new HashMap<>();
        result.put("success", response);
        return ResponseEntity.ok(result);

    }

    @PostMapping("/project")
    public ResponseEntity<?> makeProject(@RequestBody MakeProjectRequest request){
        boolean response = makeService.makeMyProject(request);
        Map<String, Object> result = new HashMap<>();
        result.put("success", response);

        return ResponseEntity.ok(result);


    }

}
