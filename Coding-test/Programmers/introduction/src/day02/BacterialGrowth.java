package day02;

public class BacterialGrowth {
    // 문제
    // 어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
    // 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때
    // t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.

    public int solution(int n, int t){
        // 한마리 1시간 - 2마리
        // 한마리 2시간 - 4마리
        // 한마리 3 시간 = 8마리
        // 한마리 n 시간 = 2의n승
        // 계산식 : 2의 t승 X n

        return ((int)Math.pow(2, t)) * n ;
    }
}
