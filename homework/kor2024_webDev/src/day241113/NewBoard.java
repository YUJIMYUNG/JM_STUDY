package day241113;


public class NewBoard { // 게시물 타입 클래스

    private String content; //내용
    private String writer; // 작성자
    private int pwd; // 비밀번호

    public String getContent() {
        return content;
    }

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

}
