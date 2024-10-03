package org.accenture.proyecto.gym.classAndTrainerManagement.controller;

import org.accenture.proyecto.gym.classAndTrainerManagement.exceptions.NoContentException;
import org.accenture.proyecto.gym.classAndTrainerManagement.models.ClassAttendance;
import org.accenture.proyecto.gym.classAndTrainerManagement.services.ClassAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/class-attendance")
public class ClassAttendanceController {
    @Autowired
    private ClassAttendanceService classAttendanceService;

    // Obtener todas las asistencias a clases
    @GetMapping("/listClass")
    public List<ClassAttendance> getAllAttendances() {
        List<ClassAttendance> attendances = classAttendanceService.getAllAttendances();
        if (attendances.isEmpty()) {
            throw new NoContentException("No content");
        }
        return attendances;
    }

    // Crear un registro de asistencia a una clase
//    @PostMapping
//    public ResponseEntity<ClassAttendance> createAttendance(@RequestBody ClassAttendance attendance) {
//        if (attendance.getTrainingClasses() == null) {
//            throw new IllegalArgumentException("Bad Request");
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        ClassAttendance createdAttendance = classAttendanceService.createAttendance(attendance);
//        return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
//    }

//    // Obtener asistencia por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ClassAttendance> getAttendanceById(@PathVariable Long id) {
//        ClassAttendance attendance = classAttendanceService.getAttendanceById(id);
//        if (attendance == null) {
//            throw new ResourceNotFoundException("Not found");
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(attendance, HttpStatus.OK);
//    }

//    // Eliminar un registro de asistencia por ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
//        if (!classAttendanceService.attendanceExists(id)) {
//            throw new ResourceNotFoundException("Not found");
//            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        classAttendanceService.deleteAttendance(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
