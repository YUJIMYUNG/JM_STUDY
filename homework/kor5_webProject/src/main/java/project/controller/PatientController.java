package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.model.dto.PatientDto;
import project.service.PatientService;

import java.util.List;

@RestController
public class PatientController {

    @Autowired private PatientService pateintService;

    // 1. 환자 등록
    @PostMapping("/patient/register.do")
    public boolean patientRegister(@RequestBody PatientDto patientDto) {
        return pateintService.patientRegister(patientDto);
    }

    // 2. 환자 목록조회
    @GetMapping("/patient/findall.do")
    public List<PatientDto> patienFindAll(){
        return pateintService.patienFindAll();
    }

    // 3. 환자 상세조회
    @GetMapping("/patient/findid.do")
    public PatientDto patienFindId(@RequestParam int patienId) {
        return pateintService.patienFindId(patienId);
    }

    // 4. 환자 정보 수정
    @PutMapping("/patient/update.do")
    public boolean patientUpdate(@RequestBody PatientDto patientDto){
        return pateintService.patientUpdate(patientDto);
    }

    // 5. 환자 삭제("/patient/register.do")
    @DeleteMapping("/patient/delete.do")
    public boolean patientDelete(@RequestParam int patienId){
        return pateintService.patientDelete(patienId);
    }
}
