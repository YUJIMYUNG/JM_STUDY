package project.model.dto;

import lombok.*;
import project.model.entity.DoctorEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private int doctorid; // 의사번호
    private String name; // 의사 이름
    private String phone; // 의사 연락처
    private String specialty; // 전공


    private String createdate; // 의사 등록날짜

    public DoctorEntity toEntity() {
        return DoctorEntity
                .builder()
                .doctorid(this.doctorid)
                .name(this.name)
                .phone(this.phone)
                .specialty(this.specialty)
                .build();
    }
}
