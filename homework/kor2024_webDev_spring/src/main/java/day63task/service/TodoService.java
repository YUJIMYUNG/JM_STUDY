package day63task.service;

import day63task.model.dto.TodoDto;
import day63task.model.entity.TodoEntity;
import day63task.model.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // 1. 할일 등록
    public boolean regist(@RequestBody TodoDto todoDto){
        // 1. 저장할 DTO를 entity로 변환
        TodoEntity todoEntity = todoDto.toEntity();

        // 2. 변환된 엔티티를 Save하고 그 결과를 엔티티에 반환 받는다.
        TodoEntity saveEntity = todoRepository.save(todoEntity);

        // 3. 할일 번호를 확인하여 엔티티가 잘 생성 됐는지 확인
        if(saveEntity.getTno() > 0) {
            return true;
        } else {
            return false;
        }

    }

    // 2. 학일 전체 조회
    public List<TodoDto> todoList() {
        // 1. 모든 엔티티를 조회
        List<TodoEntity> entityList = todoRepository.findAll();

        // 2. 모든 엔티티를 DTO로 변환
        List<TodoDto> list = new ArrayList<>();
        for(int i = 0 ; i < entityList.size() ; i++ ) {
            TodoEntity entity = entityList.get(i);
            list.add(entity.toDto());
        }
        return list;
    }

    // 3. 할일 상태 수정
    @Transactional
    public boolean update(@RequestBody TodoDto todoDto) {

        TodoEntity updateEntity = todoRepository.findById(todoDto.getTno()).get();

        updateEntity.setTcontent(todoDto.getTcontent());
        updateEntity.setTstate(todoDto.isTstate());

        System.out.println(todoDto.getTcontent());
        System.out.println(todoDto.isTstate());

        return true;
    }

    // 4. 할일 삭제
    public boolean delete(@RequestParam int tno){
        todoRepository.deleteById(tno);

        return true;

    }
}
