package day63task.model.entity;

import day63task.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "todo")
@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
@DynamicInsert
public class TodoEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tno; // 할일 식별번호(Pk)

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String tcontent; // 할 일 내용

    @Column(columnDefinition = "boolean")
    @ColumnDefault("1")
    private boolean tstate; //  할 일 상태( 0(True): 마침, 1(False: 하는 중)

    // entity ->Dto 변환 메소드
    public TodoDto toDto(){
        return TodoDto.builder()
                .tno(this.tno)
                .tcontent(this.tcontent)
                .tstate(this.tstate)
                .cdate(this.getCdate().toString())
                .udate(this.getUdate().toString())
                .build();
    }



}
