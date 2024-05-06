package com.example.aswe.volunteens.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

public class AuthDTO {
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email address")
    private String email;
    @NotBlank(message = "Enter your password")
    @Length(min=8,message = "Password must be at least 8 characters")
    private String password;

    public AuthDTO() {
    }

    public AuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
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

    public AuthDTO email(String email) {
        setEmail(email);
        return this;
    }

    public AuthDTO password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuthDTO)) {
            return false;
        }
        AuthDTO authDTO = (AuthDTO) o;
        return Objects.equals(email, authDTO.email) && Objects.equals(password, authDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    
}
