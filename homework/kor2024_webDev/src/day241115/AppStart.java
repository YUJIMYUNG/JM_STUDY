package day241115;


/*
 - 선택2(활용할분들) :
      [ 회원 서비스 구축하기 ]
      1. BoardService8MVC 폴더를 참고하여 MemberServiceMvc 회원제 서비스 구축하기
      2. 구현할 기능
         - 회원가입 기능 : 회원가입시 아이디와 비밀번호를 입력받아 회원저장처리
         - 로그인 기능 : 아이디와 비밀번호를 입력받아 저장된 회원정보가 일치하면 로그인성공
   + (선택) 추가기능 : 회원제 게시판 구축
   - 구현한 회원제서비스 와 BoardService8MVC 코드를 참고하여 로그인 성공시 게시물을 작성하고 등록된 전체 출력(볼수) 있도록 한다.
 */

import day241115.view.AuthView;

public class AppStart {
    public static void main(String[] args) {
        AuthView.getInstance().mainPage();
    }
}
