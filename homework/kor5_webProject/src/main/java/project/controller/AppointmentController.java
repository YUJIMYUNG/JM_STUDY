package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.model.dto.AppointmentDto;
import project.service.AppointmentService;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    // 1. 진료 예약 등록
    @PostMapping("/appointment/register.do")
    public boolean appointmentRegister(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.appointmentRegister(appointmentDto);
    }

    // 2. 진료 예약 목록 조회
    @GetMapping("/appointment/list.do")
    public List<AppointmentDto> appointmentFindAll(){
        return appointmentService.appointmentFindAll();
    }

    // 3. 환자별 예약 조회
    @GetMapping("/appointment/findPatient.do")
    public List<AppointmentDto> appointmentFindPatient(@RequestParam int patientId){
        return appointmentService.appointmentFindPatient(patientId);
    }

    // 4. 의사별 예약 조회
    @GetMapping("/appointment/findDoctor.do")
    public List<AppointmentDto> appointmentFindDoctor(@RequestParam int doctorId){
        return appointmentService.appointmentFindDoctor(doctorId);
    }

    // 5. 예약 수정
    @PutMapping("/appointment/update.do")
    public boolean appointmentUpdate(@RequestParam int updatdId, @RequestBody AppointmentDto updatdDto){
        return appointmentService.appointmentUpdate(updatdId, updatdDto);
    }

    // 6. 예약 취소
    @DeleteMapping("/appointment/delete.do")
    public boolean appointmentDelete(@RequestParam int deleteAppointment){
        return appointmentService.appointmentDelete(deleteAppointment);
    }
}
