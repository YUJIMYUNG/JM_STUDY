package day241112;

public class Post { // board를 만들기 위해 작성자, 내용, 비밀번호를  갖고있는 객체 생성
    String writer; // 작성자
    String content; // 내용
    int password; // 비밀번호

    // 생성자 정의
    public Post(String writer, String content, int password){ //
        this.writer = writer;
        this.content = content;
        this.password = password;
    }
}
