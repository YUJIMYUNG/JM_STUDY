package day241113;

/*
 [ BoardServiceTest3 ]
   - BoardServiceTest2 클래스에서 main함수내 while{} 문 안에 있는 게시물 등록코드 와
   게시물 전체 출력코드를 main함수 밖으로 빼서 각 함수로 구현 하시오.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BoardServiceTest3 {
    // 객체생성(생성자 사용)하고 클래스 멤버변수 선언
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<NewBoard> boardList= new ArrayList<>();
    private static NewBoard newBoard = new NewBoard();

    public static void main(String[] args) {
        while(true) {
            System.out.print("1.글쓰기 2. 출력");
            int choose = scan.nextInt();

            if(choose == 1){
               inputPost(); // 함수 입력
            } else if(choose == 2) {
                outputPost();
            } //  if/ else if end

        } // while end
    } // main end

    // 게시물 등록하는 함수
    private static void inputPost() {
        scan.nextLine();

        // 1. 제목, 작성자, 비밀번호 입력받기
        System.out.print("게시물 제목");
        String content = scan.nextLine();
        // .next() 문자열(공백x) 입력, .nextLine() 문자열(공백/띄어쓰기 포함)입력
        // .nextLine() 사용시 주의할점 : .nextLine()앞에 또 다른 .nextxx가 존재하면 의미없는 .nextLine()코드를 작성하낟.
        System.out.print("게시물 작성");
        String writer = scan.next();

        System.out.print("게시물 비밀번호");
        int password = scan.nextInt();

        // 2. 입력 받은 데이터를 arrayList에 저장
        newBoard.setContent(content);
        newBoard.setWriter(writer);
        newBoard.setPwd(password);


        boardList.add(newBoard);
    } // inputPost end

    // 게시물 출력해 보여주는 함수
    private static void outputPost() {
        // 배열 내 존재하는 게시물 모두 출력하기
        for(int i = 0; i < boardList.size() ; i++){
            System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n",
                    boardList.get(i).getContent(),
                    boardList.get(i).getWriter(),
                    boardList.get(i).getPwd());
        } // for end
    } // outputPost end
} // class end



