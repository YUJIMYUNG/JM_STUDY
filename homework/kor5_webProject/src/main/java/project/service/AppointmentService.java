package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import project.model.dto.AppointmentDto;
import project.model.entity.AppointmentEntity;
import project.model.entity.DoctorEntity;
import project.model.entity.PatientEntity;
import project.model.repository.AppointmentRepository;
import project.model.repository.DoctorRepository;
import project.model.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired private AppointmentRepository appointmentRepository;
    @Autowired private DoctorRepository doctorRepository;
    @Autowired private PatientRepository patientRepository;

    // 1. 진료 예약 등록
    @Transactional
    public boolean appointmentRegister(AppointmentDto appointmentDto) {
        Optional<PatientEntity> patientEntity = patientRepository.findById(appointmentDto.getPatientid());
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(appointmentDto.getDoctorid());

        if(!patientEntity.isPresent() || !doctorEntity.isPresent()){
            return false;
        }

        AppointmentEntity appointmentEntity = AppointmentEntity.builder()
                .appointmentdate(appointmentDto.getAppointmentdate())
                .appointmenttime(appointmentDto.getAppointmenttime())
                .patientEntity(patientEntity.get())
                .doctorEntity(doctorEntity.get())
                .status(appointmentDto.getStatus())
                .build();

        AppointmentEntity saveEntity = appointmentRepository.save(appointmentEntity);

        if(saveEntity.getAppointmentid() > 0) {
            return true;
        } else {
            return false;
        }// if-else end
    }

    // 2. 진료 예약 목록 조회
    public List<AppointmentDto> appointmentFindAll(){
        List<AppointmentEntity> appointmentEntityList = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();

        appointmentEntityList.forEach(entity -> {
            AppointmentDto appointmentDto = entity.toDto();
            appointmentDtoList.add(appointmentDto);
        });
        return appointmentDtoList;
    }

    // 3. 환자별 예약 조회
    public List<AppointmentDto> appointmentFindPatient(@RequestParam int patientId){
        PatientEntity patientEntity = patientRepository.findById(patientId).get();
        List<AppointmentEntity> appointmentEntityList = appointmentRepository.findByPatientEntity(patientEntity);

        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        appointmentEntityList.forEach ( entity -> {
            AppointmentDto appointmentDto = entity.toDto();
            appointmentDtoList.add(appointmentDto);
        });

        return appointmentDtoList;

    }

    // 4. 의사별 예약 조회
    public List<AppointmentDto> appointmentFindDoctor(int doctorId){
        DoctorEntity doctorEntity = doctorRepository.findById(doctorId).get();
        List<AppointmentEntity> appointmentEntityList = appointmentRepository.findByDoctorEntity(doctorEntity);

        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        appointmentEntityList.forEach ( entity -> {
            AppointmentDto appointmentDto = entity.toDto();
            appointmentDtoList.add(appointmentDto);
        });

        return appointmentDtoList;
    }

    // 5. 예약 수정
    @Transactional
    public boolean appointmentUpdate(int updatdId, AppointmentDto updatdDto){
        Optional<AppointmentEntity> optional  = appointmentRepository.findById(updatdId);

        if(optional.isPresent()) {
            AppointmentEntity appointmentEntity = appointmentRepository.findById(updatdId).get();
            appointmentEntity.setAppointmentdate(updatdDto.getAppointmentdate());
            appointmentEntity.setAppointmenttime(updatdDto.getAppointmenttime());
            appointmentEntity.setStatus(updatdDto.getStatus());

            return true;
        }
        return false;
    }

    // 6. 예약 취소
    @Transactional
    public boolean appointmentDelete(@RequestParam int deleteAppointment){
        AppointmentEntity appointmentEntity = appointmentRepository.findById(deleteAppointment).get();

        if(appointmentEntity == null) {
            return false;
        }

        appointmentEntity.setStatus(0); // 예약취소
        appointmentRepository.save(appointmentEntity);

        return true;
    }



}
