package day57task.controller;

import day57task.model.dto.StudendtDto;
import day57task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {
    // 만든 클래스 객체/인스턴스를 주세요
    @Autowired private StudentService studentService;

    //1. 점수 등록
    @PostMapping("/register")
    public boolean register(@RequestBody StudendtDto studendtDto){
        System.out.println("studendtDto = " + studendtDto);
        System.out.println("StudentController.register");

        boolean result = studentService.register(studendtDto);

        return result;
    }

    //2. 전체 점수 출력
    @GetMapping("/view")
    public ArrayList<StudendtDto> view(){
        ArrayList<StudendtDto> result = studentService.view();
        return result;
    }

    //3. 특정 학생 점수 수정
    @PutMapping("/modify")
    public boolean modify(@RequestParam int sNo, @RequestBody StudendtDto modifyStudentDto){
        System.out.println("sNo = " + sNo + ", modifyStudentDto = " + modifyStudentDto);
        System.out.println("StudentController.modify");
        boolean result = studentService.modify(sNo, modifyStudentDto);

        return result;
    }

    //4. 특정 학생 점수 삭제
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int sNo){
        System.out.println("sNo = " + sNo);
        System.out.println("StudentController.delete");

        boolean result = studentService.delete(sNo);
        return result;
    }


}
