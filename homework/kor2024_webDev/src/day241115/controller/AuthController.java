package day241115.controller;

import day241115.model.AuthDao;
import day241115.model.AuthDto;

import java.util.ArrayList;

public class AuthController {

    //싱글톤
    private static AuthController controller = new AuthController();
    private AuthController(){}
    public static AuthController getInstance(){
        return controller;
    }



    //회원가입
    public boolean register(String id, int pwd){
        AuthDto dto = new AuthDto(id, pwd);
        return AuthDao.getInstance().register(dto);
    } // resgister end

    //로그인
    public boolean logIn(String id, int pwd){
        //1. Dao에서 반환받은 값을 result에 저장
        AuthDto dto = new AuthDto(id, pwd);

        return AuthDao.getInstance().login(dto);
    } // login end






}
