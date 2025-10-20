package alex.valker91.migrate_data_example.repository;

import alex.valker91.migrate_data_example.model.TextLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextLineRepository extends JpaRepository<TextLineEntity, Long> {
}
