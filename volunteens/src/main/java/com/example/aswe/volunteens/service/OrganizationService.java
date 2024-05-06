package com.example.aswe.volunteens.service;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.dto.OrganizationDTO;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.respository.OrganizationRepository;


@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    public void saveOrganization(OrganizationDTO OrganizationDTO){
        Organization org = new Organization(
            OrganizationDTO.getOrganizationName(),
            OrganizationDTO.getEmail(),
            OrganizationDTO.getPassword(),
            OrganizationDTO.getOrganizationDescrp(),
            OrganizationDTO.getContactInfo(),"pending"
        );
        String encoddedPassword = BCrypt.hashpw(org.getPassword(), BCrypt.gensalt(12));
        org.setPassword(encoddedPassword);
        this.organizationRepository.save(org);

    }
    public boolean EmailExist(String email){
        
        return this.organizationRepository.existsByEmail(email);
    }

}
