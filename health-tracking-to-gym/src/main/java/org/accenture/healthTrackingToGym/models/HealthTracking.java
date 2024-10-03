package org.accenture.healthTrackingToGym.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "HEALTH_TRACKING")
@Data
public class HealthTracking {
    @Id
    @Column(name = "health_tracking_id")
    private Long healthTrackingId;

    @ManyToOne()
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "calories_burned")
    private Integer caloriesBurned;

    @Column(name = "tracking_date", nullable = false)
    private Date trackingDate;
}
