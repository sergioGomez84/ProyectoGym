package org.accenture.proyecto.gym.classAndTrainerManagement.services;

import org.accenture.proyecto.gym.classAndTrainerManagement.exceptions.ResourceNotFoundException;
import org.accenture.proyecto.gym.classAndTrainerManagement.models.Trainer;
import org.accenture.proyecto.gym.classAndTrainerManagement.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found with id: " + id));
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}
