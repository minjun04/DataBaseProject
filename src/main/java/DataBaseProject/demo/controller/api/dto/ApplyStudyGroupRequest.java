package DataBaseProject.demo.controller.api.dto;

import DataBaseProject.demo.domain.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplyStudyGroupRequest {

    //신청서
    private String selfIntroduction;

    //학생 정보
    private String studentId;

    //스터디 그룹 식별
    private int groupId;


}
