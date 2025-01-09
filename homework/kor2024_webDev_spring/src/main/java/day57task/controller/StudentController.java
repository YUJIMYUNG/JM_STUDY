package day57task.controller;

import day57task.model.dto.StudendtDto;
import day57task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@RestController 동적파일 요청 URL을 만들기 위해 Controller Annotation 사용
@Controller
public class StudentController {
    // 만든 클래스 객체/인스턴스를 주세요
    @Autowired private StudentService studentService;

    //1. 점수 등록
    @PostMapping("/api/register")
    @ResponseBody //RestController -> Contoller로 변경되었기때문에 응답을 위해 추가함
    public boolean register(@RequestBody StudendtDto studendtDto){
        System.out.println("studendtDto = " + studendtDto);
        System.out.println("StudentController.register");

        boolean result = studentService.register(studendtDto);

        return result;
    }

    //2. 전체 점수 출력
    @GetMapping("/api/view")
    @ResponseBody //RestController -> Contoller로 변경되었기때문에 응답을 위해 추가함
    public ArrayList<StudendtDto> view(){
        ArrayList<StudendtDto> result = studentService.view();
        return result;
    }

    //3. 특정 학생 점수 수정
    @PutMapping("/api/modify")
    @ResponseBody //RestController -> Contoller로 변경되었기때문에 응답을 위해 추가함
    public boolean modify(@RequestParam int sNo, @RequestBody StudendtDto modifyStudentDto){
        System.out.println("sNo = " + sNo + ", modifyStudentDto = " + modifyStudentDto);
        System.out.println("StudentController.modify");
        boolean result = studentService.modify(sNo, modifyStudentDto);

        return result;
    }

    //4. 특정 학생 점수 삭제
    @DeleteMapping("/api/delete")
    @ResponseBody //RestController -> Contoller로 변경되었기때문에 응답을 위해 추가함
    public boolean delete(@RequestParam int sNo){
        System.out.println("sNo = " + sNo);
        System.out.println("StudentController.delete");

        boolean result = studentService.delete(sNo);
        return result;
    }

    //티임리프 html 연동을 위한 코드
    //0. 메인(기본)페이지
    @GetMapping("/student")
    public String main(){
        return "/day58task/student/index.html";
    }

    //1. 학생 점수 등록 페이지
    @GetMapping("/student/regist")
    public String registPage(){
        return "/day58task/student/regist.html";
    }

    //2. 학생 전체 점수보기 페이지
    @GetMapping("/student/view")
    public String viewPage(){
        return "/day58task/student/view.html";
    }

    //3. 학생 점수 수정 페이지
    @GetMapping("/student/modify")
    public String modifyPage(){
        return "/day58task/student/modify.html";
    }

    //4. 학생 점수 삭제 페이지
    @GetMapping("/student/delete")
    public String deletePage(){
        return "/day58task/student/delete.html";
    }


}
