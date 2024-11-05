package cond;

public class CondEx03 {
    public static void main(String[] args) {
        // 문제 : 환율 계산하기
        // 달러가 0 미만이면 잘못된 금액입니다.
        // 달러가 0일 때 환전할 금액이 없습니다
        // 달러가 0 초과일 때 환전 금액은 (계산된 원하 금액)원입니다. 출력

        int dollar = -4;

        if(dollar < 0) {
            System.out.println("잘못된 금액입니다.");
        } else if(dollar == 0){
            System.out.println("환전할 금액이 없습니다.");
        } else {
            System.out.printf("환전 금액은 %d원입니다.", dollar*1200);
        }
    }
}
