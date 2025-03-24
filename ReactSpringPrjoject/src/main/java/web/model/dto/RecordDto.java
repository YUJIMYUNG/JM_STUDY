package web.model.dto;

import jakarta.persistence.*;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecordDto {

    private int rindex; // 인덱스
    private String title; // 공부기록 제목
    private String content; // 공부기록 내용
    private String duration; // 공부시간(분단위)

}
