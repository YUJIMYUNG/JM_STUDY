package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; // 상품번호

    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String pname; // 상품이름

    @Column(columnDefinition = "int", nullable = false)
    private int pprice; // 상품가격

    @Column(columnDefinition = "int", nullable = false)
    private int pstock; // 상품 재고

    @ManyToOne
    @JoinColumn(name = "cno") // 카테고리테이블에 cno를 참조함
    private CategoryEntity categoryEntity;


}
