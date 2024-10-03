package org.accenture.proyecto.gym.classAndTrainerManagement.services;

import org.accenture.proyecto.gym.classAndTrainerManagement.models.ClassAttendance;
import org.accenture.proyecto.gym.classAndTrainerManagement.repositories.ClassAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassAttendanceService {
    @Autowired
    private ClassAttendanceRepository classAttendanceRepository;

    // Obtener todas las asistencias
    public List<ClassAttendance> getAllAttendances() {
        return classAttendanceRepository.findAll();
    }

    // Crear un nuevo registro de asistencia
    public ClassAttendance createAttendance(ClassAttendance attendance) {
        return classAttendanceRepository.save(attendance);
    }

    // Obtener un registro de asistencia por ID
    public ClassAttendance getAttendanceById(Long id) {
        Optional<ClassAttendance> attendance = classAttendanceRepository.findById(id);
        return attendance.orElse(null);
    }

    // Eliminar un registro de asistencia por ID
    public void deleteAttendance(Long id) {
        classAttendanceRepository.deleteById(id);
    }

    // Verificar si existe un registro de asistencia por ID
    public boolean attendanceExists(Long id) {
        return classAttendanceRepository.existsById(id);
    }
}
