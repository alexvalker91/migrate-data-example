package alex.valker91.migrate_data_example.repository;

import alex.valker91.migrate_data_example.model.UserCopyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCopyRepository extends JpaRepository<UserCopyEntity, Long> {
}
