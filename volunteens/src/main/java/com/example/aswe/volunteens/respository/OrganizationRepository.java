package com.example.aswe.volunteens.respository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Organization;



public interface OrganizationRepository extends JpaRepository <Organization,Long>{
    Organization findByEmail(String email);
    boolean existsByEmail(String email);

}
