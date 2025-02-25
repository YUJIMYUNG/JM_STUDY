package project.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String createdate; // 의사 등록날짜

    public DoctorEntity toEntity() {
        return DoctorEntity
                .builder()
                .doctorid(this.doctorid)
                .name(this.name)
                .phone(this.phone)
                .build();
    }
}
