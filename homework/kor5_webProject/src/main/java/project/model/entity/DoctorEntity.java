package project.model.entity;

import jakarta.persistence.*;
import lombok.*;
import project.model.dto.DoctorDto;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "doctor")
public class DoctorEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorid; // 의사번호
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name; // 의사 이름
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String specialty; // 전공
    @Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
    private String phone; // 의사 연락처

    public DoctorDto toDto() {
        return DoctorDto
                .builder()
                .doctorid(this.doctorid)
                .name(this.name)
                .phone(this.phone)
                .specialty(this.specialty)
                .createdate(this.getCdate().toString())
                .build();
    }

}
