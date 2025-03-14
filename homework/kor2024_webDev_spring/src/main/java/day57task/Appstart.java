package day57task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 웹 과제4 ]
    선택1(복습과제) : day57task -> SPRING MVC 패키지/클래스 기본어노테이션 세팅 코드 3번 따라치기

    선택2(활용과제) : day57task 셋팅된 코드에서
            1. 점수 등록
            2. 전체 점수 출력
            3. 특정 학생 점수 수정
            4. 특정 학생 점수 삭제
            구축하기.
            * 조건 : C -> S -> D 순서는 깨지면 안된다.

- 정답이 필요한 경우 메일/카톡 로 요청하기.
- 제출 : itdanja@kakao.com , 01/08(수) 19:00까지 , 제출일 이후에 제출해도 됩니다.
- 제출파일 : 구현한 코드 및 파일이 위치한 본인 github 상세 주소

주제 : 학생들의 점수를 관리하는 RESTful API 구축하시오.
    1. day57task 폴더에 Spring mvc2 3tire 에 따른 패키지/클래스 구성
    2. 아래 5개 클래스를 구성하여 구축하시오.
        'AppStart' , 'StudentController' , 'StudentService' ,
        'StudentDao' , 'StudentDto'
    3. 학생 필드 : 학생번호 , 학생이름 , 국어점수 , 수학점수 , 영어점수
    4. Talend API 테스트 진행 하기.
    5. DB/테이블명은 임의로 생성 하기.

[ 1. DB/TABLE 설계 ]
drop database if exists mydb0107;
create database mydb0107;
use mydb0107;
create table student(
	sno	 int auto_increment ,
    sname varchar(30) not null ,
    skor int ,
    smath int ,
    seng int ,
	primary key( sno )
);

[ 2. DTO 코드 작성 ] : DTO 란?   VIEW <------- DTO --------> DB
    - 주로 DTO의 멤버변수는 db테이블의 속성과 dto 멤버변수는 유사 하다 + 커스텀
    - 주로 @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder

[ 3. MVC 클래스 구성 ]
    - StudentController     : @RestController 표시/스티커
    - StudentDao            : @Component 표시/스티커
    - StudentService        : @Service 표시/스티커

    + 싱글톤이란 ? 프로그램내 하나의 객체가 존재하도록 설계한 싱글톤 패턴
    + Spring은 객체관리 대신 해준다. IOC(제어역전) DI(의존성주입)
        - 특정 스티커/어노테이션 표시된 클래스들의 객체들만 관리한다.
        - MVC관련 어노테이션 : @Controller @RestController @Service @Repository @Component 등등


        [ 웹 과제5 ]
    선택1(복습과제) :
        1. resources -> templates -> day58 -> student -> 타임리프 html
        2. java -> day58 -> AppStart
            2번정도 다시 만들어보기
    선택2(활용과제) : resources -> templates -> day58 -> student -> 타임리프 html에 자바와 연동
            1. 점수 등록
            2. 전체 점수 출력
            3. 특정 학생 점수 수정
            4. 특정 학생 점수 삭제
            구축하기.
            * 조건 : JS 이용한 Fetch 함수로 day57task 에서 만든 REST API 와 통신하여 기능을 연동하시오.

- 정답이 필요한 경우 메일/카톡 로 요청하기.
- 제출 : itdanja@kakao.com , 01/09(목) 19:00까지 , 제출일 이후에 제출해도 됩니다.
- 제출파일 : 구현한 코드 및 파일이 위치한 본인 github 상세 주소
 */

@SpringBootApplication
public class Appstart {
    public static void main(String[] args) {
        SpringApplication.run(Appstart.class);
    }
}
