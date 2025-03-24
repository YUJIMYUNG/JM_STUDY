package web.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "category")
public class CategoryEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cindex;

    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String cname;

    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String color;


}
