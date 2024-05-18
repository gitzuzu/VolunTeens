package com.example.aswe.volunteens.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;



import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.UserRepositry;


@Service
public class UserService {
    @Autowired
    private UserRepositry userRepositry;


    public void saveUser(UserDTO userDTO){
        User user = new User(
            userDTO.getFirstname(),
            userDTO.getLastname(),
            userDTO.getEmail(),
            userDTO.getPassword(),
            userDTO.getAddress()
        );
        String encoddedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(encoddedPassword);
        this.userRepositry.save(user);
    }

    public boolean EmailExist(String email){
        
        return this.userRepositry.existsByEmail(email);
    }

    public boolean getUser (String email,String password){
        System.out.println(password);
        User user = this.userRepositry.findByEmail(email);
        Boolean isPassword = BCrypt.checkpw(password, user.getPassword());
        System.out.println(isPassword);
       return isPassword;
    }

    public List<User> findAllUsers() {
        return userRepositry.findAll();
    }

    public void deleteUser(Long userId) {
        userRepositry.deleteById(userId);
    }

}
