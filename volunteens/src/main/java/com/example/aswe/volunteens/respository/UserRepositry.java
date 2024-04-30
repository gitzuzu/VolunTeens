package com.example.aswe.volunteens.respository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aswe.volunteens.model.User;



public interface UserRepositry extends JpaRepository<User,Long> {
   
    boolean existsByEmail(String email);
    User findByEmail(String email);

}
