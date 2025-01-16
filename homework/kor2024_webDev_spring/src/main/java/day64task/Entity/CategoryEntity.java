package day64task.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class CategoryEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int cno; // 카테고리 번호

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String cname; // 카테고리명

}
