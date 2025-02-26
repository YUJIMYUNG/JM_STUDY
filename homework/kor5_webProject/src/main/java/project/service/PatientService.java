package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public boolean patientRegister(PatientDto patientDto) {
        PatientEntity patientEntity = patientDto.toEntity();
        PatientEntity savePatienEntity = patientRepository.save(patientEntity);

        if(savePatienEntity.getPatientid() > 0 ) {
            return true;
        } else {
            return false;
        } // if-else end

    }

    // 2. 환자 목록조회
    public List<PatientDto> patientFindAll(){
        List<PatientEntity>  patientEntityList = patientRepository.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientEntityList.forEach(entity -> {
           PatientDto patientDto = entity.toDto();
           patientDtoList.add(patientDto);
        });
        return patientDtoList;
    }

    // 3. 환자 상세조회
    public PatientDto patientFindId(int patientId) {
        Optional<PatientEntity> optional = patientRepository.findById(patientId);
        if(optional.isPresent()) {
            PatientEntity patientEntity = optional.get();
            PatientDto patientDto = patientEntity.toDto();

            return patientDto;
        } else {
            System.out.println("환자 상세조회 값 없음");
        } // if-else end
        return null;
    }

    // 4. 환자 정보 수정
    @Transactional
    public boolean patientUpdate(int updatedPatientId, PatientDto updatePatientDto){
        PatientEntity patientEntity = patientRepository.findById(updatedPatientId).get();
        patientEntity.setName( updatePatientDto.getName());
        patientEntity.setPhone( updatePatientDto.getPhone());
        patientEntity.setAddress( updatePatientDto.getAddress());

        return true;
    }

    // 5. 환자 삭제
    @Transactional
    public boolean patientDelete(@RequestParam int deletePatientId){
        // 해당 환자의 모든 예약 삭제
        // appointmentRepository.deleteByPatientEntityPatientid(deletePatiednId);
        patientRepository.deleteById(deletePatientId);
        return true;
    }

}
