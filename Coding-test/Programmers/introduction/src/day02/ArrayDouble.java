package day02;

public class ArrayDouble {
    // 문제
    // 정수 배열 numbers가 매개변수로 주어집니다.
    // numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
    public int[] solution(int[] numbers){
        for(int i = 0; i < numbers.length ; i++) {
            numbers[i] = numbers[i] * 2;
        }
        return numbers;

    }
}
