package day241115.model;

import java.util.ArrayList;

public class AuthDao {

    //싱글톤
    private static AuthDao dao = new AuthDao();
    private AuthDao(){};
    public static AuthDao getInstance() {
        return dao;
    }

    ArrayList<AuthDto> db = new ArrayList<>();

    // 회원가입 함수
    public boolean register(AuthDto dto){
        db.add(dto);
        return true;
    }

    // 로그인 성공여부 함수

    public boolean login(AuthDto dto){
        //저장된 로그인 정보와 입력한 로그인정보의 일치한지 결과깂을 담기 위한 변수 생성
        boolean result = false;

        //입력받은 id,pwd / 입력한 id,pwd가 일치한지 확인-조건문 작성
        for(int i = 0 ; i < db.size() ; i++){

            // id는 String이기 때문에 equals로 비교, pwd는 int이기때문에 ==으로 비교
            if( db.get(i).getId().equals(dto.getId()) && db.get(i).getPwd() == dto.getPwd()){
                result = true; // 맞으면 true
            } else {
                result = false; // 틀리면 false
            }// if-else end
        }
        // return 값에 넣고 반환
        return result;
    }
}
