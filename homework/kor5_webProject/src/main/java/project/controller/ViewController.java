package project.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("")
    public String index() {
        return "/index.html";
    }

    // 1. 환자 등록 화면
    @GetMapping("/patient/register")
    public String patientRegister() {
        return "/patient/register.html";
    }

    // 2. 환자 목록화면
    @GetMapping("/patient/list")
    public String patientFindAll() {
        return "/patient/list.html";
    }

    // 3. 환자 상세조회 화면
    @GetMapping("/patient/info")
    public String patientFindId() {
        return "/patient/info.html";
    }

    // 4. 의사 등록 화면
    @GetMapping("/doctor/register")
    public String doctorRegister() {
        return "/doctor/register.html";
    }

    // 5. 의사 목록화면
    @GetMapping("/doctor/list")
    public String doctorFindAll() {
        return "/doctor/list.html";
    }

    // 6. 의사 상세조회 화면
    @GetMapping("/doctor/info")
    public String doctorFindId() {
        return "/doctor/info.html";
    }

    // 7. 예약 등록/수정 화면
    @GetMapping("/appointment/update")
    public String appointmentUpdate() {
        return "/appointment/update.html";
    }

    // 8. 예약 목록화면
    @GetMapping("/appointment/list")
    public String appointmentFindAll() {
        return "/appointment/list.html";
    }

    // 9. (의사별)예약조회화면
    @GetMapping("/appointment/doctorlist")
    public String appointmentFindDoctor() {
        return "/appointment/doctorlist.html";
    }

    // 10. (환자별)예약조회화면
    @GetMapping("/appointment/patientlist")
    public String appointmentFindPatient() {
        return "/appointment/patientlist.html";
    }

}
