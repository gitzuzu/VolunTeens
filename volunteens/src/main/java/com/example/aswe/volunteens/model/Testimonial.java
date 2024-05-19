package com.example.aswe.volunteens.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String message;
    private boolean approved;



    public Testimonial() {
    }

    public Testimonial(Long id, String name, String role, String message, boolean approved) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.message = message;
        this.approved = approved;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public boolean getApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Testimonial id(Long id) {
        setId(id);
        return this;
    }

    public Testimonial name(String name) {
        setName(name);
        return this;
    }

    public Testimonial role(String role) {
        setRole(role);
        return this;
    }

    public Testimonial message(String message) {
        setMessage(message);
        return this;
    }

    public Testimonial approved(boolean approved) {
        setApproved(approved);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Testimonial)) {
            return false;
        }
        Testimonial testimonial = (Testimonial) o;
        return Objects.equals(id, testimonial.id) && Objects.equals(name, testimonial.name) && Objects.equals(role, testimonial.role) && Objects.equals(message, testimonial.message) && approved == testimonial.approved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, message, approved);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", role='" + getRole() + "'" +
            ", message='" + getMessage() + "'" +
            ", approved='" + isApproved() + "'" +
            "}";
    }

}