package com.example.aswe.volunteens.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.dto.DonationDTO;
import com.example.aswe.volunteens.model.Donation;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.DonationRepository;
import com.example.aswe.volunteens.respository.UserRepositry;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepositry userRepositry;

    public void saveDonation(DonationDTO donateDTO) {
        User user = this.userRepositry.findByEmail(donateDTO.getUserEmail());
            System.out.println(user);
        Donation donate = new Donation(donateDTO.getAmountDonated(), user, LocalDate.now());
       
        this.donationRepository.save(donate);

    }
    
}
