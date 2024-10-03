package org.accenture.proyecto.gym.classAndTrainerManagement.services;

import org.accenture.proyecto.gym.classAndTrainerManagement.exceptions.ResourceNotFoundException;
import org.accenture.proyecto.gym.classAndTrainerManagement.models.TrainingClasses;
import org.accenture.proyecto.gym.classAndTrainerManagement.repositories.TrainingClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingClassesService {
    @Autowired
    private TrainingClassesRepository trainingClassesRepository;

    public List<TrainingClasses> getAllClasses() {
        return trainingClassesRepository.findAll();
    }

    public TrainingClasses getClassById(Long id) {
        return trainingClassesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + id));
    }

    public TrainingClasses createClass(TrainingClasses classEntity) {
        return trainingClassesRepository.save(classEntity);
    }

    public void deleteClass(Long id) {
        trainingClassesRepository.deleteById(id);
    }
}
