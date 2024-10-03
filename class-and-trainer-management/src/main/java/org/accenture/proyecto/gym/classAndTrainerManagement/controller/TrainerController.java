package org.accenture.proyecto.gym.classAndTrainerManagement.controller;

import org.accenture.proyecto.gym.classAndTrainerManagement.models.Trainer;
import org.accenture.proyecto.gym.classAndTrainerManagement.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return new ResponseEntity<>(trainerService.getAllTrainers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        return new ResponseEntity<>(trainerService.getTrainerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        return new ResponseEntity<>(trainerService.createTrainer(trainer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
