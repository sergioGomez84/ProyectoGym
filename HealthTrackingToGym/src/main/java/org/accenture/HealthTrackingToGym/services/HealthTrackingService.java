package org.accenture.HealthTrackingToGym.services;

import org.accenture.HealthTrackingToGym.models.HealthTracking;
import org.accenture.HealthTrackingToGym.repositories.HealthTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthTrackingService {

    @Autowired
    private HealthTrackingRepository healthTrackingRepository;

//    public List<HealthTracking> getAllTrackingForMember(Long membershipId) {
//        return healthTrackingRepository.findByMembership_Id(membershipId);
//    }

    public List<HealthTracking> getListHealthTrackingById(Long id){
        return  healthTrackingRepository.getListHealthTrackingById(id);
    }

    public HealthTracking addHealthTracking(HealthTracking healthTracking) {
        return healthTrackingRepository.save(healthTracking);
    }

    public Optional<HealthTracking> getHealthTrackingById(Long id) {
        return healthTrackingRepository.findById(id);
    }

    public HealthTracking updateHealthTracking(Long id, HealthTracking healthTrackingDetails) {
        Optional<HealthTracking> optionalHealthTracking = healthTrackingRepository.findById(id);

        if (optionalHealthTracking.isPresent()) {
            HealthTracking healthTracking = optionalHealthTracking.get();
            healthTracking.setWeight(healthTrackingDetails.getWeight());
            healthTracking.setHeight(healthTrackingDetails.getHeight());
            healthTracking.setCaloriesBurned(healthTrackingDetails.getCaloriesBurned());
            healthTracking.setTrackingDate(healthTrackingDetails.getTrackingDate());
            return healthTrackingRepository.save(healthTracking);
        } else {
            return null;
        }
    }

    public void deleteHealthTracking(Long id) {
        healthTrackingRepository.deleteById(id);
    }
}
