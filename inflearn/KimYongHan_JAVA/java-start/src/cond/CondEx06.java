package cond;

import java.sql.SQLOutput;

public class CondEx06 {
    public static void main(String[] args) {
        // 더 큰 숫자 찾기
        // 두개 의 정수 a, b를 가지고 있다. a는 10이고 b는 20이다.
        // 삼항연산자를 사용하여 두 숫자 중 더 큰 숫자를 출력하는 코드를 작성하자
        int a = 10;
        int b = 20;
        int result =  a > b ? a : b;

        System.out.printf("더 큰 숫자는 %d입니다.", result);
    }
}
