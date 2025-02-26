package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.model.dto.DoctorDto;
import project.model.dto.PatientDto;
import project.service.DoctorService;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    // 1.의사 등록
    @PostMapping("/doctor/register.do")
    public boolean doctorRegister(@RequestBody DoctorDto doctorDto) {
        return doctorService.doctorRegister(doctorDto);
    }

    // 2. 의사 목록조회
    @GetMapping("/doctor/findall.do")
    public List<DoctorDto> doctorFindAll(){
        return doctorService.doctorFindAll();
    }

    // 3. 의사 상세조회
    @GetMapping("/doctor/findid.do")
    public DoctorDto doctorFindId(@RequestParam int doctorId) {
        return doctorService.doctorFindId(doctorId);
    }

    // 4. 의사 정보 수정
    @PutMapping("/doctor/update.do")
    public boolean doctorUpdate(@RequestParam int updatedDoctorId, @RequestBody DoctorDto updateDoctorDto){
        return doctorService.doctorUpdate(updatedDoctorId, updateDoctorDto);
    }

    // 5. 의사 삭제
    @DeleteMapping("/doctor/delete.do")
    public boolean doctorDelete(@RequestParam int deleteDoctorId){
        return doctorService.doctorDelete(deleteDoctorId);
    }
}
