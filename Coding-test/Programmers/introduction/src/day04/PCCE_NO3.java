package day04;

// 2자리 이상의 정수 number가 주어집니다.
// 주어진 코드는 이 수를 2자리씩 자른 뒤, 자른 수를 모두 더해서 그 합을 출력하는 코드입니다.
// 코드가 올바르게 작동하도록 한 줄을 수정해 주세요.

import java.util.Scanner;

public class PCCE_NO3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        for(int i=0; i<1; i++){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer+number);
    }
}