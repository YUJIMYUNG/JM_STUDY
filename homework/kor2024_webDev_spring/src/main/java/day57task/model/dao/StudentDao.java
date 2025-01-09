package day57task.model.dao;

import day57task.model.dto.StudendtDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class StudentDao {
    private Connection conn;

    private StudentDao(){
        try{
            // DB연동
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0107", "root", "auddnjs20");
        } catch (Exception e){
            e.getMessage();
        }
    }
    //1. 점수 등록
    public boolean register(StudendtDto studendtDto){
        try{
            String sql = "insert into student(sName, sKor, sMath, sEng) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studendtDto.getSname());
            ps.setInt(2, studendtDto.getSkor());
            ps.setInt(3, studendtDto.getSmath());
            ps.setInt(4, studendtDto.getSeng());
            int count = ps.executeUpdate();
            System.out.println("Inserted row count: " + count);
            System.out.println("studendtDto.getSName()" + studendtDto.getSname());
            if(count == 1 ) {return true;}
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return false;
    }

    //2. 전체 학생 점수
    public ArrayList<StudendtDto> view(){
        ArrayList<StudendtDto> list = new ArrayList<>();
        try{
            String sql = "select * from student"; // 1. sql 작성한다.
            PreparedStatement ps = conn.prepareStatement( sql ); // 2. sql 기재한다.
            // 3. sql 실행하고 결과를 조작하는 ResultSet 인터페이스로 받는다.
            ResultSet rs = ps.executeQuery();
            // 4. 조회 결과의 레코드 하나씩 조회하기 .next() : 다음레코드 이동
            while ( rs.next() ) {
                // 5. 현재 조회된 레코드를 DTO로 만들기
                StudendtDto studendtDto = new StudendtDto(
                        // * 현재 조회중인 레코드의 특정 필드명의 값 반환.  rs.get타입("필드명")
                        rs.getInt("sNo"), rs.getString("sName"),
                        rs.getInt("sKor"), rs.getInt("sMath"),
                        rs.getInt("sEng")
                );
                list.add(studendtDto);
            }
        } catch (Exception e) {  System.out.println(e); }
        return list;
    }

    //3. 특정 학생 점수 수정
    public boolean modify(int sNo, StudendtDto modifyStudentDto){
        try{
            //1. SQL 작성
            String sql = "update student set sKor = ?, sMath = ?, sEng = ? where sNo = ?";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. SQL 조작
            ps.setInt(1, modifyStudentDto.getSkor());
            ps.setInt(2, modifyStudentDto.getSmath());
            ps.setInt(3, modifyStudentDto.getSeng());
            ps.setInt(4, sNo);

            //4. SQL실행결과
            int result = ps.executeUpdate();

            if(result == 1){
                return true;
            }// if end
        }catch (Exception e){
            System.out.println(e);
        }// try-catch end
        return false;
    }

    //4.특정 학생 점수 삭제
    public boolean delete(int sNo){
        try{
            //1. SQL 작성
            String sql = "delete from student where sNo = ?";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. SQL 조작, 실행
            ps.setInt(1, sNo);
            int result = ps.executeUpdate();

            if(result == 1){
                return true;
            }// if end
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }


}
