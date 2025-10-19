package alex.valker91.migrate_data_example.repository;

import alex.valker91.migrate_data_example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
