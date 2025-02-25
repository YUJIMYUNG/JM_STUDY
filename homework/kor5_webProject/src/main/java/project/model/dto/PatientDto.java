package project.model.dto;

import lombok.*;
import project.model.entity.PatientEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private int patientid; //환자번호
    private String name; // 환자이름
    private String birthdate; // 환자생년월일
    private String phone; // 환자 연락처
    private String address; // 환자 주소

    private String createdate; // 환자등록날짜

    public PatientEntity toEntity() {
        return PatientEntity.builder()
                .patientid(this.patientid)
                .name(this.name)
                .birthdate(this.birthdate)
                .phone(this.phone)
                .address(this.address)
                .build();
    }
}
