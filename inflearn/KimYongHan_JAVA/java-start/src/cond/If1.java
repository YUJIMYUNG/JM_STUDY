package cond;

public class If1 {
    public static void main(String[] args) {
        int age = 20; // 사용자 나이

        if (age >= 18){ // true면
            System.out.println("성인 입니다."); // 코드 실행
        }

        if (age < 18){ // false면
            System.out.println("미성년자 입니다."); // 코드 실행하지 않음
        }
    }
}
