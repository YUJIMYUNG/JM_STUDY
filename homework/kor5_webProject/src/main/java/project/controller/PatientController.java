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
    public List<PatientDto> patientFindAll(){
        return pateintService.patientFindAll();
    }

    // 3. 환자 상세조회
    @GetMapping("/patient/findid.do")
    public PatientDto patientFindId(@RequestParam int patientId) {
        return pateintService.patientFindId(patientId);
    }

    // 4. 환자 정보 수정
    @PutMapping("/patient/update.do")
    public boolean patientUpdate(@RequestParam int updatedPatientId, @RequestBody PatientDto updatePatientDto){
        return pateintService.patientUpdate(updatedPatientId, updatePatientDto);
    }

    // 5. 환자 삭제
    @DeleteMapping("/patient/delete.do")
    public boolean patientDelete(@RequestParam int deletePatientId){
        return pateintService.patientDelete(deletePatientId);
    }
}
