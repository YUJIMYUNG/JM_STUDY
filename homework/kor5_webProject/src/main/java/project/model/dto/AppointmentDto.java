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

    public AppointmentEntity toEntity() {
        return AppointmentEntity
                .builder()
                .appointmentid(appointmentid)
                .status(this.status)
                .appointmentdate(this.appointmentdate)
                .appointmenttime(this.appointmenttime)
                .build();
    }


}
