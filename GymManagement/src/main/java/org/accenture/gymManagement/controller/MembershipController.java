package org.accenture.gymManagement.controller;

import org.accenture.gymManagement.models.Membership;
import org.accenture.gymManagement.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @GetMapping("/list")
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

//    @GetMapping("/find")
//    public String homePage() {
//        Optional<Membership> membership = membershipService.findById(id);
//
//        return "home";
//    }

    @GetMapping("/find/{id}")
    public List<Membership> membershipById(Long id) {
        List<Membership> memberships = membershipService.getListMembershipById(id);

        return memberships;
    }

    @PostMapping("/create")
    public Membership createMembership(@RequestBody Membership membership) {

        return membershipService.addMembership(membership);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Membership> updateMembership(@PathVariable Long id, @RequestBody Membership membershipDetails) {
//        Membership updatedMembership = membershipService.updateMembership(id, membershipDetails);
//
//        if (updatedMembership != null) {
//            return ResponseEntity.ok(updatedMembership);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return ResponseEntity.noContent().build();
    }
}
