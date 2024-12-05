package fr.okteo.testtechnique.repository;

import fr.okteo.testtechnique.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
