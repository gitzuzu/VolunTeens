package com.example.aswe.volunteens.service;


import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.dto.OrganizationDTO;
import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.OrganizationRepository;

import jakarta.servlet.http.HttpSession;


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

    public void updateOrganization(HttpSession session,OrganizationDTO organizationDTO){
        Organization existingOrganization = organizationRepository.findById(organizationDTO.getOrganizationId()).get();
        updateCommonFields(existingOrganization,organizationDTO);
         this.organizationRepository.save(existingOrganization);
         session.setAttribute("org", existingOrganization);
    }
    
      public void updateCommonFields(Organization existingOrganization, OrganizationDTO organizationDTO) {
        existingOrganization.setOrganizationName(organizationDTO.getOrganizationName());
        existingOrganization.setEmail(organizationDTO.getEmail());
        existingOrganization.setOrganizationDescrp(organizationDTO.getOrganizationDescrp());
        existingOrganization.setContactInfo(organizationDTO.getContactInfo());
      }
public void updateOrganizationdash(OrganizationDTO organizationDTO){
    Organization existingOrganization = organizationRepository.findById(organizationDTO.getOrganizationId()).get();
    updateCommonFields(existingOrganization,organizationDTO);
     this.organizationRepository.save(existingOrganization);
}

    public List<Organization> findAllOrganizations() {
        return this.organizationRepository.findAll();
    }

    
    public void deleteOrganization(Long organizationId) {
        organizationRepository.deleteById(organizationId);
    }

    public Organization findOrganization(Long organizationId) {
        return organizationRepository.findById(organizationId).get();
    }

    
}
