package day03;

public class Discount {
    // 문제
    // 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
    //구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    // 10 ≤ price ≤ 1,000,000
    //price는 10원 단위로(1의 자리가 0) 주어집니다.
    //소수점 이하를 버린 정수를 return합니다.
    public int solution(int price){
       if(price >= 500000){
           price = (int) (price - (price * 0.2));
       } else if(price >= 300000){
           price = (int) (price - (price * 0.1));
       } else if(price >= 100000){
           price = (int) (price - (price * 0.05));
       }
       return price;
    }

}
