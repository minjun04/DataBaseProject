package domain.service;

import api.Contoller.api.AuthLoginResponse;
import domain.Entity.Student;
import domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
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

    public Student Login(String studentId) throws IllegalAccessException {
        Student student = studentRepository.findByStudentId(studentId);

        if(student == null){
            throw new IllegalAccessException("존재하지 않는 아이디 입니다.");
        }

        return student;

    }

}
