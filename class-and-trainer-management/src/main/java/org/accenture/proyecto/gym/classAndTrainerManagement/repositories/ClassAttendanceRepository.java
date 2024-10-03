package org.accenture.proyecto.gym.classAndTrainerManagement.repositories;

import org.accenture.proyecto.gym.classAndTrainerManagement.models.ClassAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassAttendanceRepository extends JpaRepository<ClassAttendance, Long> {
}
