//문제 : N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
//입력 : 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
//출력 : 입력으로 주어진 숫자 N개의 합을 출력한다.

import java.util.Scanner;

public class q11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n자리 수를 입력받음

        String sNum = sc.next(); // n자리수 sNum을 입력받음

        int sum = 0; // 결과값 sum 초기화

        char[] cNum = sNum.toCharArray(); // 문자열을 한글자씩 배열로 담아주는 toCharArray메소드 사용하여 분리시킴

        for(int i = 0; i < cNum.length ; i++){
            sum += cNum[i] - '0'; // 문자열'0'을 이용하여 형변환
        }

        System.out.println(sum);
    }
}
