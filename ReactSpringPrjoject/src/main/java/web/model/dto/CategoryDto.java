package web.model.dto;

import jakarta.persistence.*;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int index;
    private String name;
    private String color;


}
