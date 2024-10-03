package org.accenture.proyecto.gym.classAndTrainerManagement.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CLASS_ATTENDANCE")
@Data
public class ClassAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_attendance_id", nullable = false)
    private Long classAttendanceId;

    @ManyToOne
    @JoinColumn(name = "training_classes_id")
    private TrainingClasses trainingClasses;

    @ManyToOne
    @JoinColumn(name = "health_tracking_id")
    private HealthTracking healthTracking; // Desde el microservicio de Seguimiento de Salud y Bienestar

    private Date attendanceDate;

}
