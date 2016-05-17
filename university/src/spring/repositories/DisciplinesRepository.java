package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.jpa.DisciplinesEntity;

/**
 * Created by Антон on 13.05.2016.
 */
@Repository
public interface DisciplinesRepository extends JpaRepository<DisciplinesEntity, Integer> {
}
