package com.example.aswe.volunteens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.dto.OpportunityDTO;
import com.example.aswe.volunteens.model.Opportunity;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.respository.OpportunityRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    public void postedOpportunity(OpportunityDTO opportunityDTO,HttpSession session){
        Organization org = (Organization) session.getAttribute("org");
        Opportunity opportunity = new Opportunity
        (opportunityDTO.getTitle(), 
        opportunityDTO.getDescription(),
        opportunityDTO.getLocation() , 
        opportunityDTO.getRequirements(),
        org);
        this.opportunityRepository.save(opportunity);
    }

    public boolean TitleExist(String title){
        
        return this.opportunityRepository.existsByTitle(title);
    }

    public List allOpportunities(){
        List<Opportunity>opportunities=opportunityRepository.findAll();
        return opportunities;
    }
}
