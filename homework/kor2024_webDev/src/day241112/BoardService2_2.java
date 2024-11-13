package day241112;

import java.util.Scanner;

public class BoardService2_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] content = new String[100];
        String[] writer = new String[100];

        while(true) {
            System.out.println("1. 게시물 쓰기 2. 게시물 출력 선택 : ");
            int choose = scan.nextInt();

            if(choose == 1){
                System.out.println("새로운 게시물 제목 : ");
                String cont = scan.next();

                System.out.println("새로운 게시물 작성자 : ");
                String writ = scan.next();

                boolean save = false;

                for(int i = 0; i < content.length ; i++) {
                    if(content[i] == null) {
                        content[i] = cont;
                        writer[i] = writ;

                        save = true;
                        break;
                    }  // if end
                } // for end
                if(save) {
                    System.out.println("게시물 쓰기 성공");
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈공간이 없습니다.");
                } // if end

            }// if end
            if(choose == 2){
                for(int i = 0; i < content.length; i++) {
                    if(content[i] != null) {
                        System.out.printf("작성자 : %s, 내용 : %s \n", writer[i], content[i]);
                    }// if end
                } // for end
            } // if end
        }// while end
    }
}
