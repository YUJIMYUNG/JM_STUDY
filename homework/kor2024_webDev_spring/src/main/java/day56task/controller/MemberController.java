package day56task.controller;

import day56task.model.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/day56task")
public class MemberController {

    //1. 회원가입
    @PostMapping("/signup")
    public boolean signup(@RequestBody MemberDto sginupDto){
        System.out.println("MemberController.signup");
        System.out.println("sginupDto = " + sginupDto);

        // Dao 생성하고 주석 풀기
        // boolean result = MemberDao.getInstance().signup(sginupDto);
        // return result;

        return true;
    }

    //2. 로그인
    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto loginDto){
        System.out.println("MemberController.login");
        System.out.println("loginDto = " + loginDto);

        //Dao 생성하고 주석 풀기
        //boolean result = MemberDao.getInstance().login(loginDto);
        //return result;

        return true;
    }

    //3. 회원수정
    @PutMapping("/updateMember")
    public boolean updateMember(@RequestBody MemberDto updateMemberDto){
        System.out.println("MemberController.updateMember");
        System.out.println("updateMemberDto = " + updateMemberDto);
        //Dao 생성하고 주석 풀기
        // boolean result = MemberDat.getInstance().updateMember(updateMemberDto);
        //return result;

        return true;
    }

    //4. 내정보보기
    @GetMapping("viewMemberInfo")
    public ArrayList<MemberDto> viewMemberInfo(){
        System.out.println("MemberController.viewMemberInfo");

        //Dao 생성하고 주석 풀기
        //ArrayLisg<MemberDto> result = MemberDao.jetInstance().viewMemberInfo();
        //return result;

        return null;
    }

    //5. 회원탈퇴
    @DeleteMapping("deleteAccount")
    public boolean deleteAccount(@RequestParam int memberNo){
        System.out.println("MemberController.deleteAccount");
        System.out.println("memberNo = " + memberNo);

        //Dao 생성하고 주석 풀기
        //boolean result = MemberDao.getInstance().delete(memberNo);
        //return result;

        return true;
    }
}
