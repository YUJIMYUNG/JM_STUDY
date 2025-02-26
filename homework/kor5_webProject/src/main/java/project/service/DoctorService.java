package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.dto.DoctorDto;
import project.model.entity.DoctorEntity;
import project.model.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired private DoctorRepository doctorRepository;

    // 1.의사 등록
    @Transactional
    public boolean doctorRegister(DoctorDto doctorDto) {
        DoctorEntity doctorEntity = doctorDto.toEntity();
        DoctorEntity saveDoctorEntity = doctorRepository.save(doctorEntity);

        if(saveDoctorEntity.getDoctorid() > 0 ) {
            return true;
        } else {
            return false;
        } // if-else end
    }

    // 2. 의사 목록조회
    public List<DoctorDto> doctorFindAll(){
        List<DoctorEntity>  doctorEntityList = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        doctorEntityList.forEach(entity -> {
            DoctorDto doctorDto = entity.toDto();
            doctorDtoList.add(doctorDto);
        });
        return doctorDtoList;
    }

    // 3. 의사 상세조회
    public DoctorDto doctorFindId(@RequestParam int doctorId) {
        Optional<DoctorEntity> optional = doctorRepository.findById(doctorId);
        if(optional.isPresent()) {
            DoctorEntity doctorEntity = optional.get();
            DoctorDto doctorDto = doctorEntity.toDto();

            return doctorDto;
        } else {
            System.out.println("의사 상세조회 값 없음");
        } // if-else end
        return null;
    }

    // 4. 의사 정보 수정
    @Transactional
    public boolean doctorUpdate(@RequestParam int updatedDoctorId, @RequestBody DoctorDto updateDoctorDto){
        Optional<DoctorEntity> optional = doctorRepository.findById(updatedDoctorId);

        if(optional.isPresent()) {
            DoctorEntity doctorEntity = doctorRepository.findById(updatedDoctorId).get();
            doctorEntity.setName( updateDoctorDto.getName());
            doctorEntity.setPhone( updateDoctorDto.getPhone());
            doctorEntity.setSpecialty( updateDoctorDto.getSpecialty());

            return true;
        }
        return false;
    }

    // 5. 의사 삭제
    @Transactional
    public boolean doctorDelete(@RequestParam int deleteDoctorId){
        // 해당 의사의 모든 예약 삭제
        // appointmentRepository.deleteByPatientEntityPatientid(deletePatiednId);
        doctorRepository.deleteById(deleteDoctorId);
        return true;
    }
}
