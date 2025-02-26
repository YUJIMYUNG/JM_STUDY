package project.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;
import project.model.dto.AppointmentDto;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Component
public class AppointmentEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentid; //접수번호
    @Column(columnDefinition = "date", nullable = false)
    private String appointmentdate; // 예약된날짜
    @Column(columnDefinition = "time", nullable = false)
    private String appointmenttime; //예약된 시간

    @Column(columnDefinition = "tinyint")
    @ColumnDefault("1") // 1 - 접수됨, 0 - 취소됨
    private int status; // 접수상태

    @ManyToOne
    @JoinColumn(name = "patientid")
    private PatientEntity patientEntity; // 환자 fk

    @ManyToOne
    @JoinColumn(name = "doctorid")
    private  DoctorEntity doctorEntity; // 의사 fk

    public AppointmentDto toDto() {
        return AppointmentDto
                .builder()
                .appointmentid(appointmentid)
                .status(this.status)
                .appointmentdate(this.appointmentdate)
                .appointmenttime(this.appointmenttime)
                .createdate(this.getCdate().toString())
                .patientid(patientEntity.getPatientid())
                .doctorid(doctorEntity.getDoctorid())
                .patientname(patientEntity.getName())
                .doctorname(doctorEntity.getName())
                .build();
    }


}
