package com.example.aswe.volunteens.respository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Opportunity;
import com.example.aswe.volunteens.model.Organization;



public interface OpportunityRepository extends JpaRepository<Opportunity,Long>{
    boolean existsByTitle(String title);
    Page<Opportunity> findByStatus(String status, Pageable pageable);
    Page<Opportunity> findByOrganizationAndStatus(Organization organization, String status, Pageable pageable);

}
