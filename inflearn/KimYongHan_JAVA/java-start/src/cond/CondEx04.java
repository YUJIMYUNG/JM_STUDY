package cond;

public class CondEx04 {
    public static void main(String[] args) {
        // 평점에 따른 영화 추천하기
        // 요청한 평점 이상의 영화를 찾아서 추천하는 프로그램
        // 어바웃타임 = 평점 9
        // 토이스토리 - 평점 8
        // 고질라 - 평점 7

        double rating = 8;
        if(rating <= 9){
            System.out.println("어바웃 타임을 추천합니다.");
        }

        if(rating <= 8){
            System.out.println("토이스토리를 추천합니다.");
        }

        if(rating <= 7){
            System.out.println("고질라를 추천합니다.");
        }
    }
}
