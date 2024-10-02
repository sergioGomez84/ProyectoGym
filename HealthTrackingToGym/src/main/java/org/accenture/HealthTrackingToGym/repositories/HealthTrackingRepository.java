package org.accenture.HealthTrackingToGym.repositories;

import org.accenture.HealthTrackingToGym.models.HealthTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthTrackingRepository extends JpaRepository<HealthTracking, Long> {
    //List<HealthTracking> findByMembership_Id(Long membershipId);
    @Query("select h from HealthTracking h " +
            "JOIN Membership m ON m.membershipId = h.membership.membershipId " +
            "where h.healthTrackingId = :id  ")
    List<HealthTracking> getListHealthTrackingById(Long id);
}
