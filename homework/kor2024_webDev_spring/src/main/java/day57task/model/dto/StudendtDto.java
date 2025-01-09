package day57task.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StudendtDto {
    private int sno;
    private String sname;
    private int skor;
    private int smath;
    private int seng;
}


