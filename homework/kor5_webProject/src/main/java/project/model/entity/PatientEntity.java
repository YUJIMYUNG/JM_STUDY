package project.model.entity;

import jakarta.persistence.*;
import lombok.*;
import project.model.dto.PatientDto;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient")
public class PatientEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientid; //환자번호
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name; // 환자이름
    @Column(columnDefinition = "Date", nullable = false)
    private String birthdate; // 환자생년월일
    @Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
    private String phone; // 환자 연락처
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String address; // 환자 주소

    public PatientDto toDto() {
        return PatientDto
                .builder()
                .patientid(this.patientid)
                .name(this.name)
                .birthdate(this.birthdate)
                .phone(this.phone)
                .address(this.address)
                .createdate(this.getCdate().toString())
                .build();
    }
}
