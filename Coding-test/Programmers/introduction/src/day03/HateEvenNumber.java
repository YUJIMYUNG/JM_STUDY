package day03;

public class HateEvenNumber {
    // 문제
    // 정수 n이 매개변수로 주어질 때,
    // n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

    public int[] solution(int n) {
        int count = (n + 1) / 2; // n 이하의 홀수의 갯수
        int [] oddNumberArr = new int[count]; // 홀수의 갯수만큼 배열 크기 생성

        int index = 0;
        for(int i = 0; i <= n ; i += 2){
            oddNumberArr[index] = i;
            index++;
        }
        return oddNumberArr;
    }

    public static void main(String[] args) {
        int arr1[] = {};
        int num = 15;

        for(int i = 0; i < num; i++){
            if(i % 2 == 1){
                arr1 = new int[arr1.length+1];
                arr1[i] = i;
            }
            System.out.println(arr1[i]);

        }

    }

}
