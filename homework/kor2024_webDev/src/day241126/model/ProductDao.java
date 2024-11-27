package day241126.model;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    //JDBC 인터페이스
    private Connection conn;

    //생성자에서 DB연동 코드 작성
    public ProductDao(){
        try {
            //1.
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1126", "root", "auddnjs20");

            //3. test
            System.out.println("ProductDB Connection OK");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ProductDB Connection Fail");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("ProductDB Connection Fail");
        }// try-catch end
    }//생성자 end

    //1. 제품 추가 함수
    public boolean productAdd(ProductDto productDto){
        try{
            //1. SQL 작성
            String sql = "insert into product(name, price)values(?,?)";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3.SQL에 값 대입
            ps.setString(1, productDto.getName()); // 첫번째 필드(제품명)에 입력받은 제품명 대입
            ps.setInt(2, productDto.getPrice()); // 두번째 필드(제품가격)에 입력받은 제품가격 대입

            //4. SQL실행
            ps.executeUpdate();

            return true; // 성공했을때 true 반환
        } catch (SQLException e){
            e.getMessage();
            System.out.println("제품 추가시 예외발생");
        }
        return false;
    }//productAdd end

    //2. 전체 제품정보 출력 함수
    public ArrayList<ProductDto> productPrint(){
        ArrayList<ProductDto> list = new ArrayList<>(); // 조회된 레노트를 객체화해서 저장할 리스트객체 선언
        try{
            //1. SQL 작성
            String sql = "select * from product";

            //2.SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. SQL조작, SQL 실행
            ResultSet rs = ps.executeQuery();

            //4. 결과
            while(rs.next()) {
                //5. 레코드를 읽어서 필드별 데이터 호출
                int idx = rs.getInt("idx");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                // 6. 각 레코드의 호출된 필드값을 객체화
                ProductDto productDto = new ProductDto(idx, name, price);

                // 7. 반복문 한 번에 레코드 한 개를 dto 반환
                list.add(productDto);
            }// while end
        } catch (SQLException e){
            e.getMessage();
            System.out.println("제품 출력시 예외 발생");
        } // try-catch end

        return list; // 반복문 돌려서 담긴 list반환
    }// productPrint end

    // 3. 제품 삭제 함수
    public boolean productDelete(int deleteIdx){
        try{
            //1. SQL 작성
            String sql = "delete from product where idx=?";

            //2. SQL기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. 기재한 SQL조작
            ps.setInt(1, deleteIdx);

            //4.SQL 실행 및 결과
            int result = ps.executeUpdate();

            //5. 메소드 반환
            if(result == 1){
                return true;
            }// if end
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("제품 삭제시 예외발생");
        } // try-catch end

        // 삭제 실패시 falset 반환
        return false;
    } // productDelete end

    //4. 제품 수정 함수
    public boolean productUpdate(ProductDto updateDto){
        try{
            //1.SQL 작성
            String sql = "update product set name=?, price=? where idx=?";

            //2. SQL기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. SQL조작
            ps.setString(1, updateDto.getName());
            ps.setInt(2, updateDto.getPrice());
            ps.setInt(3, updateDto.getIdx());

            //4. 기재된 SQL실행, 결과
            int result = ps.executeUpdate();

            //5. 메소드 반환
            if(result ==1) {
                return true;
            } // if end
        } catch(SQLException e){
            e.getMessage();
            System.out.println("제품 삭제시 예외발생");
        }//try-catch end

        return false;
    }//productUpdate end
}
