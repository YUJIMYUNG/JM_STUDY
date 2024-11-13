package day241112;

import java.util.Scanner;

public class BoardService2_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] content = new String[100];
        String[] writer = new String[100];

        while(true){
            System.out.print("1. 게시물 쓰기 2. 게시물 출력 : ");
            int choose = scan.nextInt();

            if(choose == 1){
                System.out.print("새로운 게시물 제목");
                String cont = scan.next();

                System.out.print("새로운 게시물 작성자");
                String writ = scan.next();

                boolean save = false;

                for(int i = 0; i < content.length ; i++ ){
                    content[i] = cont;
                    writer[i] = writ;

                    save = true;

                    break;
                }// for end

                if(save) {
                    System.out.println("게시물 쓰기 성공");
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                } // if else end
            } // if end

            if(choose == 2){
                for(int i = 0; i < content.length; i++) {
                    if(content[i] != null){
                        System.out.printf("작성자 : %s, 내용 : %s \n", writer[i], content[i]);
                    }
                } //for end
            } // if end
        }// while end
    }
}
