package com.example.aswe.volunteens.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.dto.DonationDTO;
import com.example.aswe.volunteens.model.Donation;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.DonationRepository;
import com.example.aswe.volunteens.respository.OrganizationRepository;
import com.example.aswe.volunteens.respository.UserRepositry;



@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private OrganizationRepository organizationRepository;

    public void saveDonation(DonationDTO donateDTO) {
        User user = this.userRepositry.findByEmail(donateDTO.getUserEmail());
        Optional<Organization> orgOptional = this.organizationRepository.findById(donateDTO.getOrgId());

        Organization organization = orgOptional.orElse(null);

            System.out.println(user);
        Donation donate = new Donation(donateDTO.getAmountDonated(), user, LocalDate.now(),organization);
        this.donationRepository.save(donate);

    }

    public List<Donation> findDonationsByOrganization(Organization organization) {
        return donationRepository.findByOrganization(organization);
    }

        
}
