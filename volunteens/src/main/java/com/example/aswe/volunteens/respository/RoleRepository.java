package com.example.aswe.volunteens.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.Role;



public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
