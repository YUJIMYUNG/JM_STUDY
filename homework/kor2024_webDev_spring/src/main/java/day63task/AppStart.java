package day63task;
/*
[ 웹 과제7 : JPA 과제 ]
    주제 : '나만의 할일 목록'(TODOLIST) RESTful API 구축, JPA 활용
        1. '나만의 할일 목록' 의 Controller, Service , Repository , Entity , Dto , AppStart 구성하여 구현하시오.
        2. entity 와 dto 변환함수 활용 해주세요.
        3. baseTime 활용 해주세요.
            1. 할일 등록
            2. 할일 전체 조회
            3. 할일 상태 수정
            4. 할일 삭제
        * 할일 속성 : 할일식별번호(pk) , 할일내용 , 할일상태  의 3가지 속성은 필수로 해주세요. 등록날짜와 수정날짜는 baseTime 활용
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
