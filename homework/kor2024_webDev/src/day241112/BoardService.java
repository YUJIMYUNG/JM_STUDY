package day241112;

//- 내용[String타입] 과 작성자[String타입] 과 비밀번호[int타입] 로 구성된 게시물 클래스를 설계
//      - 게시물 객체 최대 100개 까지 저장하는 서비스 구축
//          - 조건 : main함수 1개 와 배열은 최대1까지 사용 하여 구현
//          - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현

import java.util.Scanner;

public class BoardService {
    public static void main(String[] args) {
        Post[] postBox = new Post[100]; // 게시물 객체 최대 100개까지 저장하는 배열로 선언

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("1. 게시물 쓰기 2. 게시물 출력 선택 : ");
            int choose = scanner.nextInt(); // 게시물 쓰기 or 출력 입력

            if (choose == 1) { // 1. 게시물 쓰기를 선택했을 때
                System.out.print("새로운 게시물 제목 : ");  // 제목 작성하고 cont에 저장
                String cont = scanner.next();

                System.out.print("새로운 게시물 작성자 : "); // 작성자 입력하고 writ에 저장
                String writ = scanner.next();

                System.out.print("새로운 게시물 비번 : "); // 비번 입력하고 pwd에 저장
                int pwd = scanner.nextInt();

                boolean save = false; // 상태 저장 변수

                for (int i = 0; i < postBox.length; i++) {
                    if (postBox[i] == null) { // post에 i번째 게시물이 없으면 코드실행(제목, 작성자, 비번 저장)
                        Post posts = new Post(writ, cont, pwd); // 게시물 내용을 담은 객체 생성;
                        postBox[i] = posts; // post 배열 i 번째에 posts 객체 (게시물 내용 담은것)를 넣기

                        save = true; // 저장 성공했으면 save변수 true로 변환
                        break; // 저장 하나 하고 반복 종료
                    }// if문 종료

                } // for문 종료
                if( save ) {
                    System.out.println("게시물 쓰기 성공");
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                } // if(save)문 종료
            } // if(choose == 1) 조건문 종료


            // 출력해주는 코드
            if (choose == 2) {
                for (int i = 0; i < postBox.length; i++) {
                    if (postBox[i] != null) {// i 번째 post에 게시물이 존재하면
                        System.out.printf("제목 : %s, 작성자 : %s, 비밀번호 : %s%n", postBox[i].writer, postBox[i].content, postBox[i].password);
                    }
                } // for문 종료
            }  // if문 종료

        }// while문 종료
    }
}
