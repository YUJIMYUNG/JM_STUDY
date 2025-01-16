package day64task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppStart {
    /*
    조건 1: 3개 엔티티를 설계하시오
     제품 카테고리 : 카테고리 번호, 캌테고리명
     제품: 제품번호, 제품명, 제품가격
     주문 : 주문번호, 주문갯수

    조건 2: 3개의 엔티티를 양방향으로 구현하시오
        - 제품테이블에 카테고리번호FK 포함
        - 주문테이블에 제품번호 FK 포함

    조건 3 : 모든 엔티티는 BaseTIme을 상속받으시오

     */
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
