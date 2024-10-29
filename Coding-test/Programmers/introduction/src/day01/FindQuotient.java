package day01;

public class FindQuotient {
    // 문제 설명
    // 정수 num1, num2가 매개변수로 주어질 때,
    // num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.

    // 제한 사항
    // 0 < num1 ≤ 100
    // 0 < num2 ≤ 100

    // 입출력 예
    // num1이 10, num2가 5이므로 10을 5로 나눈 몫 2를 return 합니다.
    // 입출력 예 #2
    //num1이 7, num2가 2이므로 7을 2로 나눈 몫 3을 return 합니다.
    public int solution(int num1, int num2){
        int answer = 0;
        answer = num1 / num2 ;

        return answer;
    }
}
