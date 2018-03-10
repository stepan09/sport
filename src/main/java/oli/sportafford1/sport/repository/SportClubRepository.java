/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.repository;

import oli.sportafford1.sport.model.SportClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportClubRepository extends JpaRepository<SportClub, Long>{
}
