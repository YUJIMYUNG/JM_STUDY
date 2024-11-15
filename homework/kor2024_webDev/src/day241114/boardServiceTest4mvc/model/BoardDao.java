package day241114.boardServiceTest4mvc.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BoardDao {
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto) {

        // 1. 게시물 등록 접근 함수
        boardDB.add(boardDto);
        return true;
    }

    // 2. 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint() {
        return boardDB;
    }
}
