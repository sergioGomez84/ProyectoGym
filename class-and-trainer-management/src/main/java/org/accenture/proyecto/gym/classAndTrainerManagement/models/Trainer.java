package org.accenture.proyecto.gym.classAndTrainerManagement.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TRAINER")
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id", nullable = false)
    private Long trainerId;

    @Column(name = "trainer_name", nullable = false)
    private String name;

    @Column(name = "trainer_last_name", nullable = false)
    private String lastName;

    @Column(name = "expertise", nullable = false)
    private String expertise;
}
