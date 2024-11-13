package day241112;

import java.util.Scanner;

public class BoardService2_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] content = new String[100] ;
        String[] writer = new String[100]; // String 데이터 100 개를 저장할 수 있는 배열 생성

        while(true){
            System.out.println("1. 게시물 쓰기 2. 게시물 출력 : ");
            int choose = scan.nextInt();
            if(choose == 1){
                System.out.println("새로운 게시물 제목");
                String cont = scan.next();

                System.out.println("새로운 게시물 작성자 :");
                String writ  = scan.next();

                // 인덱스 - 0부터 마지막 인덱스 99까지 1씩 증가
                // 스위ㅣㅊ 변수 = 상태 저장하는 변수
                boolean save = false; // 처음에는 false 해서 저장 실패 했다는 뜻
                for(int index = 0; index <= content.length-1; index++) {
                    if(content[index] == null){ // 만약애 index번째 게시물이 비어있으면
                        content[index] = cont; // 비어있는 게시물 내용에 입력받은 내용 저장
                        writer[index] = writ; // 비어있는 게시물 작성자에 입력받은 내용 저장
                        save = true; // 만약에 저장 성공했으면 save변수에 true 값으로 변경
                        break; // 만약에 저장을 했으면 1개 저장해야 하므로 break해서 반복문 종료
                    }// if end
                } // for end

                // for 종료 후에 save 변수 값이 true 성공, false면 실패
                if(save){
                    System.out.println("게시물 쓰기 성공");
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                } // if else end
            } // if end

            if(choose == 2){
                for(int index = 0; index <= content.length-1;index++) {
                    if(content[index] != null) { // 만약에 index번째 게시물이 존재하면
                        System.out.printf("작성자 : %s, 내용 : %s \n", writer[index], content[index]);
                    } // if end
                }// for end
            } // if end
        } // while end
    } // main end
}  // class end
