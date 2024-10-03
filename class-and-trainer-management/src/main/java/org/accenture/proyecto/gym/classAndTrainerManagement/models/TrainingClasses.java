package org.accenture.proyecto.gym.classAndTrainerManagement.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TRAINING_CLASSES")
@Data
public class TrainingClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_classes_id", nullable = false)
    private Long trainingClassesId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "schedule", nullable = false)
    private Date schedule;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;

}
