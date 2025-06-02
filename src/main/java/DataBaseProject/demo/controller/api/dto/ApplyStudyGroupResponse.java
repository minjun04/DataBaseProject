package DataBaseProject.demo.controller.api.dto;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ApplyStudyGroupResponse {

    //신청서
    private String selfIntroduction;

    //학생 정보
    private Student student;

    //스터디 그룹 식별
    private int groupId;


}
