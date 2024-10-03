package org.accenture.proyecto.gym.classAndTrainerManagement.controller;

import org.accenture.proyecto.gym.classAndTrainerManagement.models.TrainingClasses;
import org.accenture.proyecto.gym.classAndTrainerManagement.services.TrainingClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/training-classes")
public class TrainingClassesController {
    @Autowired
    private TrainingClassesService trainingClassesService;

    @GetMapping
    public ResponseEntity<List<TrainingClasses>> getAllClasses() {
        return new ResponseEntity<>(trainingClassesService.getAllClasses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingClasses> getClassById(@PathVariable Long id) {
        return new ResponseEntity<>(trainingClassesService.getClassById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainingClasses> createClass(@RequestBody TrainingClasses classEntity) {
        return new ResponseEntity<>(trainingClassesService.createClass(classEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        trainingClassesService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
