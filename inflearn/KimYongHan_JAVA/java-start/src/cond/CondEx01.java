package cond;

public class CondEx01 {
    public static void main(String[] args) {
        // 학점 계산하기
        // 90점 이상은 A
        // 80-90 B
        // 70-80 C
        // 60-70 D
        // 60점 미만은 F

        int score = 66;

        if(score >= 90) {
            System.out.println("A 학점입니다.");
        } else if(score >= 80) {
            System.out.println("B 학점 입니다.");
        } else if(score >= 70) {
            System.out.println("C 학점 입니다.");
        } else if(score >= 60) {
            System.out.println("D 학점 입니다.");
        } else {
            System.out.println("F 학점 입니다. ");
        }
    }
}
