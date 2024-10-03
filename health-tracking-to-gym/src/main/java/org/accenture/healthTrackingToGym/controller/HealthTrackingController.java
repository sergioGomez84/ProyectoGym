package org.accenture.healthTrackingToGym.controller;

import org.accenture.healthTrackingToGym.models.HealthTracking;
import org.accenture.healthTrackingToGym.services.HealthTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HealthTrackingController {

    @Autowired
    private HealthTrackingService healthTrackingService;

//    @GetMapping("/tracking/member/{membershipId}")
//    public List<HealthTracking> getTrackingForMember(@PathVariable Long membershipId) {
//        return healthTrackingService.getAllTrackingForMember(membershipId);
//    }


    @GetMapping("/tracking/member/{membershipId}")
    public List<HealthTracking> getTrackingForMember(@PathVariable Long membershipId) {
        return healthTrackingService.getListHealthTrackingById(membershipId);
    }

    @GetMapping("/tracking/{id}")
    public ResponseEntity<HealthTracking> getTrackingById(@PathVariable Long id) {
        Optional<HealthTracking> healthTracking = healthTrackingService.getHealthTrackingById(id);

        if (healthTracking.isPresent()) {
            return ResponseEntity.ok(healthTracking.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public HealthTracking createTracking(@RequestBody HealthTracking healthTracking) {
        return healthTrackingService.addHealthTracking(healthTracking);
    }

    @PutMapping("/update/tracking/{id}")
    public ResponseEntity<HealthTracking> updateTracking(@PathVariable Long id, @RequestBody HealthTracking healthTrackingDetails) {
        HealthTracking updatedTracking = healthTrackingService.updateHealthTracking(id, healthTrackingDetails);

        if (updatedTracking != null) {
            return ResponseEntity.ok(updatedTracking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/Tracking/{id}")
    public ResponseEntity<Void> deleteTracking(@PathVariable Long id) {
        healthTrackingService.deleteHealthTracking(id);
        return ResponseEntity.noContent().build();
    }
}
