package day63task.model.dto;

import day63task.model.entity.TodoEntity;
import lombok.*;

@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class TodoDto {
    private int tno;
    private String tcontent;
    private boolean tstate;
    private String cdate; // 할 일 등록 날짜
    private String udate;// 할일 수정 날짜

    public TodoEntity toEntity() {
        return TodoEntity.builder()
                .tno(this.tno)
                .tcontent(this.tcontent)
                .tstate(this.tstate)
                .build();
    }
}
