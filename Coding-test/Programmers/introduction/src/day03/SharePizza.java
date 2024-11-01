package day03;

public class SharePizza {
    // 문제
    // 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다.
    // 피자를 나눠먹을 사람의 수 n이 주어질 때,
    // 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
    public int solution(int n) {
        // 1명 - 1판
        // 2명 - 1판
        // 3명 - 1판
        // 4명 - 1판
        // 6명 - 1판
        // 7명 - 1판
        // 8명 - 2판
        // 14명 - 2판
        // 15명 - 3판

        int pizza = n / 7 ; // 7로 나눈 수의 몫
        return n % 7 == 0 ? pizza : pizza + 1; // n명이 7로 나눈 수의 나머지가 있으면 pizza + 1

    }

}
