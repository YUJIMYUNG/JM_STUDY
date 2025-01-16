package day64task.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; // 제품번호

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private  String pname; // 제품명

    @Column(columnDefinition = "int", nullable = false)
    private int pprice; // 제품가격
}
