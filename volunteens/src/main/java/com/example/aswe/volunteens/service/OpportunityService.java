package com.example.aswe.volunteens.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page allApprovedOpportunities(Pageable pageable){
        Page<Opportunity>opportunities= opportunityRepository.findByStatus("approved", pageable);
        System.out.println(opportunities);
        return opportunities;
    }

    public Opportunity findOpportunity(Long opportunityid){
        return opportunityRepository.findById(opportunityid).get();
    }

    public List<Opportunity> allOpportunities(){
        return opportunityRepository.findAll();
    }
    
    public void updateOpportunityStatus(Long opportunityId,String newStatus){
        Opportunity opportunity = findOpportunity(opportunityId);
        if(opportunity!=null){
        opportunity.setStatus(newStatus);
        opportunityRepository.save(opportunity);
        }else{
           throw new IllegalArgumentException("Invalid organization Id:" + opportunityId);
        }
    }

    public Page findOpportunitiesByOrganization(Pageable pageable,Organization organization){
        return opportunityRepository.findByOrganizationAndStatus(organization, "approved", pageable);
    }
}
