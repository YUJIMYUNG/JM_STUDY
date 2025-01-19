package day65task.model.entity;

import day65task.model.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class OrderEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;

    @Column(columnDefinition = "int")
    private int oquantity;

    @Column(columnDefinition = "boolean")
    private boolean ostate;

    @ManyToOne // fk
    @JoinColumn(name = "mno") // 회원테이블 mno를 참조함
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "pno") // 상품테이블에 pno를 참조함
    private ProductEntity productEntity;

    // entity --> dto 로 변환
    public OrderDto toOrderDto() {
        return OrderDto.builder()
                .ono(this.ono)
                .oquantity(this.oquantity)
                .ostate(this.ostate)
                .ocdate(this.getCdate().toString())
                .build();
    }
}
