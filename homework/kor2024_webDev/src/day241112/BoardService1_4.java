package day241112;

import java.util.Scanner;

public class BoardService1_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String content1 = null;
        String writer1 = null;
        String content2 = null;
        String writer2 =  null;
        String content3 = null;
        String writer3 =  null;

        while(true) {
            System.out.print("1. 게시물 쓰기 2. 게시물 출력 선택 : ");
            int choose = scan.nextInt();

            if(choose == 1){
                System.out.print("새로운 게시물 내용: ");
                String content = scan.next();

                System.out.print("새로운 게시물 작성자");
                String writer = scan.next();

                if(content1 == null) {
                    content1 = content;
                    writer1 = writer;
                } else if(content2 == null) {
                    content2 = content;
                    writer2 = writer;
                } else if(content3 == null) {
                    content3 = content;
                    writer3 = writer;
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                }

            } else if(choose == 2){
                if(content1 !=  null){
                    System.out.printf("\"작성자 : %s, 내용: %s \n", content1, writer1);
                } else if(content2 != null){
                    System.out.printf("\"작성자 : %s, 내용: %s \n", content2, writer2);
                } else if(content3 != null) {
                    System.out.printf("\"작성자 : %s, 내용: %s \n", content3, writer3);
                }
            }

        }
    }
}
