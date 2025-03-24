package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
