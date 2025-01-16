package day06;

import java.util.Scanner;

public class TEST1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int step = sc.nextInt();
        int end = sc.nextInt();

        for(int i = start; i < end; i-=step){//10부터 시작 2씩 감소 끝은 3
            System.out.println(i);
        }

        System.out.println(start);
    }
}
