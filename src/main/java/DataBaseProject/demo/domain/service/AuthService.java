package DataBaseProject.demo.domain.service;

import DataBaseProject.demo.domain.Entity.Student;
import DataBaseProject.demo.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StudentRepository studentRepository;


    //아이디 중복체크
    public void duplicationCheck(String studentId) throws IllegalAccessException {
        Student student =studentRepository.findByStudentId(studentId);

        if(student != null){
            throw new IllegalAccessException("이미 존재하는 아이디입니다.");
        }
    }

    public boolean login(String studentId)  {
        Student student = studentRepository.findByStudentId(studentId);

        if(student == null){
            return false;
        }

        return true;
    }

}
