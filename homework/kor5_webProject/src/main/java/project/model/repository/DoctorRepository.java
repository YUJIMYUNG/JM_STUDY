package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
}
