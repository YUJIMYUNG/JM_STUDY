package day65task;

/*
[ 웹 과제9 : JPA 연관관계 설계 과제 ]
    주제 : 마켓컬리 모방
        1. 데이터베이스 설계
        2. 데이터베이스 샘플 구상(insert)
        3. 데이터베이스 설계 기반으로 엔티티 만들기
        4. 엔티티의 Data.sql에 구상한 샘플 Insert 테이블당 5개 이상

    REST 서비스 구축
        1. 특정한 회원이 주문한 제품 내역 모두 조회(출력)
        2. 특정한 회원이 제품을 주문(등록)
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
