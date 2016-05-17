package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.jpa.CoursesEntity;

/**
 * Created by Антон on 13.05.2016.
 */
@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity, Integer> {
}
