package cond;

public class CondEx02 {
    public static void main(String[] args) {
        // 거리에 따른 운송 수단 선택하기
        // 거리가 1km 이하면 "도보
        // 10 이하면 자전거
        // 100 이하면 자동차
        // 100 초과하면 비행기

        int distance = 1;

        if(distance <= 1){
            System.out.println("도보를 이용하세요.");
        } else if(distance <= 10) {
            System.out.println("자전거를 이용하세요.");
        } else if(distance <= 100) {
            System.out.println("자동차를 이용하세요.");
        } else {
            System.out.println("비행기를 이용하세요.");
        }
    }
}
