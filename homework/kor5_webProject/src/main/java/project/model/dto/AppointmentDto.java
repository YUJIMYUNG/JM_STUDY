package project.model.dto;

import lombok.*;
import project.model.entity.AppointmentEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private int appointmentid; //접수번호
    private int status; // 접수상태
    private String appointmentdate; // 예약된 날짜
    private String appointmenttime; // 예약된 시간
    private String createdate; //접수등록날짜

    private int doctorid; // 의사번호 fk
    private int patientid; //환자번호 fk

    private String doctorname; //의사 이름
    private String patientname; //환자 이름

    public AppointmentEntity toEntity() {
        return AppointmentEntity
                .builder()
                .appointmentid(appointmentid)
                .status(this.status != 0 ? this.status : 1)
                .appointmentdate(this.appointmentdate)
                .appointmenttime(this.appointmenttime)
                .build();
    }


}
