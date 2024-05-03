package com.example.aswe.volunteens.dto;


import java.util.Objects;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    private Long userId;
    @NotBlank(message = "Enter your Firstname")
    private String firstname;
    @NotBlank(message = "Enter your lastname")
    private String lastname;
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email address")
    private String email;
    @NotBlank(message = "Enter your password")
    @Length(min=8,message = "Password must be at least 8 characters")
    private String password;
    @NotBlank(message = "Re-enter your password")
    private String cpassword;
    @NotBlank(message = "Enter your address")
    private String address;

    public UserDTO() {
    }

    public UserDTO(Long userId, String firstname, String lastname, String email, String password, String cpassword, String address) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
        this.address = address;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return this.cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(userId, userDTO.userId) &&
               Objects.equals(firstname, userDTO.firstname) &&
               Objects.equals(lastname, userDTO.lastname) &&
               Objects.equals(email, userDTO.email) &&
               Objects.equals(password, userDTO.password) &&
               Objects.equals(cpassword, userDTO.cpassword) &&
               Objects.equals(address, userDTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstname, lastname, email, password, cpassword, address);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "userId=" + userId +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", cpassword='" + cpassword + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
