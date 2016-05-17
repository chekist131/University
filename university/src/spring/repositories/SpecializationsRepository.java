package spring.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.jpa.SpecializationsEntity;

/**
 * Created by Антон on 13.05.2016.
 */
@Repository
public interface SpecializationsRepository extends JpaRepository<SpecializationsEntity, Integer> {

}
