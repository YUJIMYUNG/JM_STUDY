package project.model.entity;

import jakarta.persistence.*;
import lombok.*;
import project.model.dto.AppointmentDto;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentid; //접수번호
    @Column(columnDefinition = "date", nullable = false)
    private String appointmentdate; // 예약된날짜
    @Column(columnDefinition = "time", nullable = false)
    private String appointmenttime; //예약된 시간

    @Column(columnDefinition = "tinyint")
    private int status; // 접수상태

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientid")
    private PatientEntity patientEntity; // 환자 fk

    @ManyToOne(cascade = CascadeType.ALL)
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
                .build();
    }


}
