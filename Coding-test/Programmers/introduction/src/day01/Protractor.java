package day01;

public class Protractor {

    // 문제
    // 각에서 0도 초과 90도 미만은 예각, 90도는 직각,
    // 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다.
    // 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2,
    // 둔각일 때 3, 평각일 때 4를 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    // 0 < angle ≤ 180
    //angle은 정수입니다.

    public int solution(int angle){
        boolean acuteAngle = angle > 0 && angle < 90;
        boolean rightAngle = angle == 90;
        boolean obtuseAngle = angle > 90 && angle < 180;
        boolean straightAngle = angle == 180;
        int answer = 0;

        if(acuteAngle) {
            answer = 1;
        } else if (rightAngle) {
            answer = 2;
        } else if (obtuseAngle) {
            answer = 3;
        } else if (straightAngle) {
            answer = 4;
        }

        return answer;
    }
}
