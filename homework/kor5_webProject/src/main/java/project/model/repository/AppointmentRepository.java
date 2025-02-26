package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.AppointmentEntity;
import project.model.entity.DoctorEntity;
import project.model.entity.PatientEntity;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

    // 환자별 예약 조회
    List<AppointmentEntity> findByPatientEntity(PatientEntity patientEntity);

    // 의사별 예약 조회
    List<AppointmentEntity> findByDoctorEntity(DoctorEntity doctorEntity);
}
