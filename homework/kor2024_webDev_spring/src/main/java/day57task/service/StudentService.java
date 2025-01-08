package day57task.service;

import day57task.model.dao.StudentDao;
import day57task.model.dto.StudendtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    // spring이 만든 빈(객체.인스턴스)을 줘
    @Autowired private StudentDao studentDao;

    //1. 학생 점수 등록
    public boolean register(StudendtDto studendtDto){
        return studentDao.register(studendtDto);
    }

    //2. 전체 학생 점수 보기
    public ArrayList<StudendtDto> view() {
        return studentDao.view();
    }

    //3. 특정 학생 점수 수정
    public boolean modify(int sNo, StudendtDto modifyStudentDto){
        return studentDao.modify(sNo, modifyStudentDto);
    }

    //4.특정 학생 점수 삭제
    public boolean delete(int sNo){
        return studentDao.delete(sNo);
    }


}
