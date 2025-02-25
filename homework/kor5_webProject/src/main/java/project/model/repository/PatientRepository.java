package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
}
