package day63task.controller;

import day63task.model.dto.TodoDto;
import day63task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired private TodoService todoService;


    //1. 할일 등록
    @PostMapping("/todo/regist")
    public boolean regist(@RequestBody TodoDto todoDto){
        return todoService.regist(todoDto);
    }

    //2. 할일 전체 조회
    @GetMapping("/todo/todolist")
    public List<TodoDto> todoList(){
        return todoService.todoList();
    }

    //3. 할일 상태 수정
    public boolean update(@RequestBody TodoDto todoDto){
        return todoService.update(todoDto);
    }

    //4. 할일 삭제
    public boolean delete(@RequestParam int tno){
        return todoService.delete(tno);
    }

}
