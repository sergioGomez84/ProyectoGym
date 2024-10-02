package org.accenture.gymManagement.repositories;

import org.accenture.gymManagement.models.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {


    @Override
    List<Membership> findAll();

    @Override
    Optional<Membership> findById(Long aLong);

    @Query("select m from Membership m where m.membershipId = :id ")
    List<Membership> getListMembershipById(Long id);

}