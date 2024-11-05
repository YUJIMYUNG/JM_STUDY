package cond;

public class CondEx07 {
    public static void main(String[] args) {
        // 홀수 짝수 찾기
        // 정수 x가 주어지고  x가 짝수이면 짝수, 홀수이면 홀수를 출력하는 프로그램

        int x = 21;
        String result = x % 2 == 0 ? "짝수" : "홀수";
        System.out.printf("x = %d, %s", x, result);
    }
}
