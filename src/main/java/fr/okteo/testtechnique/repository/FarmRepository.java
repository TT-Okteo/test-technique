package fr.okteo.testtechnique.repository;

import fr.okteo.testtechnique.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
