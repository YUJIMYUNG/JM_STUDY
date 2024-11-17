package day241115.view;

import day241115.controller.AuthController;

import javax.swing.text.View;
import java.util.Scanner;

public class AuthView {

    // 싱글톤
    private static AuthView view = new AuthView();
    private AuthView () {}
    public static AuthView getInstance() {
        return view;
    } // 싱글톤 ed

    Scanner scanner = new Scanner(System.in);

    public void mainPage() {
        while(true){
            System.out.print("1.회원가입 2.로그인 : " );
            int choose = scanner.nextInt();

            if (choose == 1) {
                register();
            } else if (choose == 2) {
                logIn();
            } // if else if ed
        } // while end

    }

    // 회원가입 메서드
    void register() {
        System.out.print("아이디를 입력하세요 : ");
        String id = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        int pwd = scanner.nextInt();

        boolean result = AuthController.getInstance().register(id, pwd);
        if (result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }
    } // register ed


    // 로그인 메서드
    void logIn() {
        System.out.print("아이디를 입력하세요 : ");
        String id = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        int pwd = scanner.nextInt();

        // 입력받은 값을 컨트롤러에 전달
        boolean result = AuthController.getInstance().logIn(id, pwd);

        // 컨트롤러에게 전달 후 결과를 받아 출력하기
        if(result) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }// if-else end
    }
}
