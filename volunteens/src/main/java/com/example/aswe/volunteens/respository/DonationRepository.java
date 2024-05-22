package com.example.aswe.volunteens.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Donation;
import com.example.aswe.volunteens.model.Organization;

public interface DonationRepository extends JpaRepository<Donation, Long>{
    List<Donation> findByOrganization(Organization organization);
    List<Donation> findTop10ByOrderByDonationDateDesc();

}
