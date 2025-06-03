package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.Entity.application.StudyApplication;
import DataBaseProject.demo.domain.Entity.StudyGroup;
import DataBaseProject.demo.domain.repository.ApplyRepository;
import DataBaseProject.demo.domain.repository.StudentRepository;
import DataBaseProject.demo.domain.repository.StudyGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ApplyService {

    private final StudyGroupRepository studyGroupRepository;
    private final ApplyRepository applyRepository;
    private final StudentRepository studentRepository;
    //스터디 그룹 신청
    public boolean studyGroupApply(String SelfInfo, String studentId, int groupId){
        StudyGroup studyGroup =studyGroupRepository.findByGroupId(groupId);
        Student student=studentRepository.findByStudentId(studentId);

        StudyApplication studyApplication = new StudyApplication(student,studyGroup,"대기",LocalDate.now(),SelfInfo);
        applyRepository.save(studyApplication);
        return true;

    }

    //신청서 수락
    public boolean applyAccept(StudyApplication studyApplication){

        studyApplication.setStatus("수락");

        //수락
        if(studyApplication.getStatus().equals("수락")) {
            return true;
        }
        else{
            return false;
        }
    }

    //신청서 거절
    public boolean applyRefuse(StudyApplication studyApplication){

        studyApplication.setStatus("거절");

        //거절
        if(studyApplication.getStatus().equals("거절")) {
            return true;
        }
        else{
            return false;
        }
    }




}
