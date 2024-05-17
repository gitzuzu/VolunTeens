package com.example.aswe.volunteens.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Application;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    
}
