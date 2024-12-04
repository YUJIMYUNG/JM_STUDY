
//문제
//수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

import java.util.Scanner;

//입력
//첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
// 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
//출력
// 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
public class q11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long suNo = sc.nextLong(); // 숫자 갯수
        long quizNo = sc.nextLong(); // 질의 갯수

        long[] S = new long[(int) (suNo + 1)];// 합을 담을 배열

        for(int i = 1; i <= S.length; i++){
            S[i] = S[i -1] + sc.nextLong(); // 합배열 공식
        }

        for(int q = 0; q < quizNo; q++){
            int i = sc.nextInt(); // i번째
            int j = sc.nextInt(); // j번째
            System.out.println(S[j] - S[j-1]); // 구간합 공식
        }
    }
}
