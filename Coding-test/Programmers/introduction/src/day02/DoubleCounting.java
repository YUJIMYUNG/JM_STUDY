package day02;

public class DoubleCounting {
    // 문제
    // 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때,
    // array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.

    public int solution(int[] array, int n){
        int count = 0;
        for(int i = 0; i < array[i]; i++) {
            if(array[i] == n) {
                 count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = 0;
        int[] array = {1, 1, 2, 3, 4, 5};
        int n = 1;
        for(int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
            if(array[i] == n) {
                count ++;
            }

        }

        System.out.println(count);


    }

}
