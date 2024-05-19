package com.example.aswe.volunteens.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.UserRepositry;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserRepositry userRepositry;

    public void saveUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getAddress(),
                false

        );
        String encoddedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(encoddedPassword);
        this.userRepositry.save(user);
    }

    public boolean EmailExist(String email) {

        return this.userRepositry.existsByEmail(email);
    }

    public boolean getUser(String email, String password) {
        System.out.println(password);
        User user = this.userRepositry.findByEmail(email);
        Boolean isPassword = BCrypt.checkpw(password, user.getPassword());
        System.out.println(isPassword);
        return isPassword;
    }

    public List<User> findAllUsers() {
        return userRepositry.findAll();
    }

    public User findUser(Long userId) {
        return userRepositry.findById(userId).get();
    }

    public void deleteUser(Long userId) {
        userRepositry.deleteById(userId);
    }

    public void toggleAdmin(Long userId) {
        User optionalUser = userRepositry.findById(userId).get();

        if (optionalUser != null) {
            optionalUser.setIsAdmin(!optionalUser.getIsAdmin());
            userRepositry.save(optionalUser);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

    public void updateUser(UserDTO userDTO) {
        User existingUser = userRepositry.findById(userDTO.getUserId()).get();
        updateCommonFields(existingUser, userDTO);
        if (!userDTO.getPassword().isEmpty()) {
            String encoddedPassword = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12));
            existingUser.setPassword(encoddedPassword);
        } else {
            existingUser.setPassword(userDTO.getPassword());
        }
        userRepositry.save(existingUser);
    }

    public void updateUserProfile(UserDTO userDTO, HttpSession session) {
        User existingUser = userRepositry.findById(userDTO.getUserId()).get();
        updateCommonFields(existingUser, userDTO);
        userRepositry.save(existingUser);
        session.setAttribute("user", existingUser);
    }

    public void updateCommonFields(User existingUser, UserDTO userDTO) {
        existingUser.setFirstname(userDTO.getFirstname());
        existingUser.setLastname(userDTO.getLastname());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setAddress(userDTO.getAddress());
    }
}
