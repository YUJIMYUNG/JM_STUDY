package day241114.boardServiceTest4mvc.controller;


import day241114.boardServiceTest4mvc.model.BoardDao;
import day241114.boardServiceTest4mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 3. 입력받은 객체를 저장하기 위해 Dao 전달하고 결과를 응답받기
    BoardDao boardDao = new BoardDao();

    // 1. 게시물 등록 제어 함수
    public boolean boardWrite(String content, String writer, int pwd){

        //1. 다양한 데이터 검사 = 유효성 검사

        //2. 유효성 검사 통과 했으면 서로 다른 데이터를 하나(객체)로 만들기
        BoardDto boardDto = new BoardDto(content, writer, pwd);

        return boardDao.boardWrite(boardDto);
    } // boardWrite end

    // 2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> boardPrint(){
        return boardDao.boardPrint();
    } // boardPrint end


}
