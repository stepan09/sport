package oli.sportafford1.sport.repository;

import oli.sportafford1.sport.model.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsmanRepository extends JpaRepository<Sportsman, Long> {
}
