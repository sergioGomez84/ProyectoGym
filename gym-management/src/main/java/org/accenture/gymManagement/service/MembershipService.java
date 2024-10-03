package org.accenture.gymManagement.service;

import org.accenture.gymManagement.models.Membership;
import org.accenture.gymManagement.repositories.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public Optional<Membership> findById(Long id){

        return  membershipRepository.findById(id);
    }

    public List<Membership> getListMembershipById(Long id){

        return  membershipRepository.getListMembershipById(id);
    }
//    public Optional<Membership> getMembershipById(Long id) {
//        return membershipRepository.findById(id);
//    }

    public Membership addMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

//    public Membership updateMembership(Long id, Membership membershipDetails) {
//        Optional<Membership> optionalMembership = membershipRepository.findById(id);
//
//        if (optionalMembership.isPresent()) {
//            Membership membership = optionalMembership.get();
//            membership.setMemberName(membershipDetails.getMemberName());
//            membership.setMembershipType(membershipDetails.getMembershipType());
//            membership.setStartDate(membershipDetails.getStartDate());
//            membership.setEndDate(membershipDetails.getEndDate());
//            return membershipRepository.save(membership);
//        } else {
//            return null;
//        }
//    }

    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }
}
