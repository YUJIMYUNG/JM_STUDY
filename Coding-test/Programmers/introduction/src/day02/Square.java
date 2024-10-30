package day02;

public class Square {
    // 문제
    // 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
    // 정수 n이 매개변수로 주어질 때,
    // n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.

    public int solution(int n) {
        int var = (int)Math.sqrt(n); // n의 제곱근을 구하기
        return n == var * var ? 1 : 2;
    }

}
