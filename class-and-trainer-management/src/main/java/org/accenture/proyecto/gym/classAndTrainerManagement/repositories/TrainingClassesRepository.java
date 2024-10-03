package org.accenture.proyecto.gym.classAndTrainerManagement.repositories;

import org.accenture.proyecto.gym.classAndTrainerManagement.models.TrainingClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingClassesRepository extends JpaRepository<TrainingClasses, Long> {
}
