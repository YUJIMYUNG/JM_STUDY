package day55task.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoDao {
    // 연동 인터페이스
    private Connection conn;

    private TodoDao(){
        try{
            //DB연동
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0104", "root", "auddnjs20");
        } catch (Exception e){
            e.getMessage();
            System.out.println("db연결 실패" + e.getMessage());
        }
    }// 생성자 end

    private static TodoDao instance = new TodoDao(){};
    public static TodoDao getInstance(){
        return instance;
    }//getinstance end

    //1. 할일 등록
    public boolean register(TodoDto todoDto){
        try{
            String sql = "insert into todo(todoContent, todoState) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getTodoContent());
            ps.setBoolean(2, todoDto.isTodoState());

            int count = ps.executeUpdate();
            if(count == 1) { return true; }
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            System.out.println(e);
        } //try-catch end
        return false;
    }

    //2. 할일 출력
    public ArrayList<TodoDto> view(){
        ArrayList<TodoDto> todoList = new ArrayList<>();
        try{
            String sql = "select * from todo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                TodoDto todoDto = new TodoDto(
                        rs.getInt("todoNo"),
                        rs.getString("todoContent"),
                        rs.getBoolean("todoState")
                );
                todoList.add(todoDto);
            }// while end
        }catch (Exception e){
            e.getMessage();
        }// try-catch end
        return todoList;
    }// view end

    //3. 할일 수정
    public boolean modify(TodoDto modifyTodoDto){
        try{
            String sql = "update todo set todoState = ? where todoNo =?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, modifyTodoDto.isTodoState());
            ps.setInt(2, modifyTodoDto.getTodoNo());

            int result = ps.executeUpdate();

            if(result == 1) { return true;}
        } catch (Exception e){
            e.getMessage();
        } //try-catch end
        return false;
    }// modify end

    //4/ 할일 삭제
    public boolean delete(int deleteTodoNo) {
        try {
            String sql = "delete from todo where todoNo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, deleteTodoNo);
            int result = ps.executeUpdate();

            if (result == 1) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println(e.getMessage());
        }//try-catch end
        return false;
    }// delete end
}
