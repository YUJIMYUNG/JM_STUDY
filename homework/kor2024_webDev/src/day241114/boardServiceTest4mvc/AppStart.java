package day241114.boardServiceTest4mvc;

import day241114.boardServiceTest4mvc.view.BoardView;

/*
  [ BoardServiceTest4 ]
   - 강의내 boardservice8mvc패키지 코드를 재사용하여 프로그램내 출력기능을 MVC 구조로 완성하시오.
   - 조건 : 코드흐름은 무조건 V --> C --> M(DAO)  또는  M(DAO) ---> C --> V 로 한다. 예] view에서는 dao객체를 호출할수 없다.
 */
public class AppStart {
    public static void main(String[] args) {
        // 메인 뷰 요청
        // - 다른 클래스의 존재하는 함수를 호출하는 방법
        // -- 1. 객체를 생성한 후 객체명, 메소드명() 호출
        // -- 단 패키지가 다르면 메서드룰 public 함수로 선언한다.
        BoardView view = new BoardView();
        view.mainPage();


    }
}
