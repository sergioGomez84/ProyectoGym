package org.accenture.proyecto.gym.classAndTrainerManagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Membership")
@Data
public class Membership {
    @Id
    @Column(name = "membership_id")
    private Long membershipId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "membership_type", nullable = false)
    private String membershipType;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

}
