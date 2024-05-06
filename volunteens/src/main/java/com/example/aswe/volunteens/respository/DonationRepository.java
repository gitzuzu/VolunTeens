package com.example.aswe.volunteens.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{
    
}
