package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import project.model.dto.PatientDto;
import project.model.entity.PatientEntity;
import project.model.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired private PatientRepository patientRepository;

    // 1. 환자 등록
    public boolean patientRegister(@RequestBody PatientDto patientDto) {
        PatientEntity patientEntity = patientDto.toEntity();

        return true;
    }

    // 2. 환자 목록조회
    public List<PatientDto> patienFindAll(){
        List<PatientEntity>  patientEntityList = patientRepository.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientEntityList.forEach(entity -> {
           PatientDto patientDto = entity.toDto();
           patientDtoList.add(patientDto);
        });
        return patientDtoList;
    }

    // 3. 환자 상세조회
    public PatientDto patienFindId(@RequestParam int patienId) {
        Optional<PatientEntity> optional = patientRepository.findById(patienId);
        if(optional.isPresent()) {
            PatientEntity patientEntity = optional.get();
        }
        return null;
    }

    // 4. 환자 정보 수정
    public boolean patientUpdate(@RequestBody PatientDto patientDto){
        return true;
    }

    // 5. 환자 삭제("/patient/register.do")
    public boolean patientDelete(@RequestParam int patienId){
        return true;
    }

}
