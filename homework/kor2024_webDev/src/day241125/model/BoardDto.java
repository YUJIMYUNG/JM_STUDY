package day241125.model;

public class BoardDto {

    private int num; // 게시물번호
    private String content; //내용
    private String writer; // 작성자
    private int pwd; // 비밀번호


    // 매개변수 3개 존재하는 생성자
    public BoardDto(String content, String writer, int pwd) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
    }

    // 매개변수 4개 존재하는 생성자
    public BoardDto(int num, String content, String writer, int pwd){
        this.num = num;
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
    }

    // 3. 메소드(멤버함수)
    // -getter 함수(필드 값 호출) : private선언된 필드를 public으로 함수를 외부 클래스로부터 간접접근을 허용
    public String getContent() {
        return content;
    }

    // - setter 함수(필드 값 저장) : private 선언된 필드를 public 함수로 외부 클래스로부터 간접접근을 허용
    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    // num의 getter, setter 추가
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Board{" +
                "num='" + num + '\'' +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
