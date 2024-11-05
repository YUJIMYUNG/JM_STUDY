package cond;

public class Swtitch3 {
    public static void main(String[] args) {
        // 새로운 swtich문

        int grade = 3;

        int coupon = switch (grade){
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default -> 500;
        };
        System.out.println("발급받은 쿠폰 : " + coupon);
    }
}
