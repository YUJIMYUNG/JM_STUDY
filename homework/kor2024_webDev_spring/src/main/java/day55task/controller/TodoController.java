package day55task.controller;

import day55task.model.TodoDao;
import day55task.model.TodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoController {

    //1. 할일 등록
    @PostMapping("/register")
    public boolean register(@RequestBody TodoDto todoDto){
        System.out.println("TodoController.register");
        System.out.println("todoDto = " + todoDto);
        boolean result = TodoDao.getInstance().register(todoDto);
        return result;
    }

    //2. 할일 출력
    @GetMapping("/view")
    public ArrayList<TodoDto> view(){
        ArrayList<TodoDto> result = TodoDao.getInstance().view();
        return result;
    }

    //3. 할일 수정
    @PutMapping("/modify")
    public boolean modify(@RequestBody TodoDto modifyTodoDto){
        System.out.println("TodoController.modify");
        System.out.println("modifyTodoDto = " + modifyTodoDto);
        boolean result = TodoDao.getInstance().modify(modifyTodoDto);
        return result;
    }

    //4. 할일 삭제
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int todoNo){
        System.out.println("TodoController.delete");
        System.out.println("todoNo = " + todoNo);
        boolean result = TodoDao.getInstance().delete(todoNo);

        return result;
    }
}
