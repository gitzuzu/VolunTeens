package com.example.aswe.volunteens.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Application;
import com.example.aswe.volunteens.model.Opportunity;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List <Application> findByOpportunity(Opportunity opportunity);
}   