package DataBaseProject.demo.controller.api;

import DataBaseProject.demo.controller.api.dto.MakeProjectRequest;
import DataBaseProject.demo.controller.api.dto.MakeStudyRequest;
import DataBaseProject.demo.domain.service.MakeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/make")
public class MakingApiController {

   private final MakeService makeService;

    @PostMapping("/study")
    public boolean makeStudyGroup(@RequestBody MakeStudyRequest request){
        return makeService.makeMyStudyGroup(request);
    }

    @PostMapping("/project")
    public boolean makeProject(@RequestBody MakeProjectRequest request){
        return makeService.makeMyProject(request);

    }

}
