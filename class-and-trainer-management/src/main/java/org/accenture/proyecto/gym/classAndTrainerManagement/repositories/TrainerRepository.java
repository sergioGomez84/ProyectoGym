package org.accenture.proyecto.gym.classAndTrainerManagement.repositories;

import org.accenture.proyecto.gym.classAndTrainerManagement.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
