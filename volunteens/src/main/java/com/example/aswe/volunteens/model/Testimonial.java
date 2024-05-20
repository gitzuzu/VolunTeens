package com.example.aswe.volunteens.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Testimonial() {
    }

    public Testimonial( String name, String role, String message, boolean approved, Organization organization, User user) {

        this.name = name;
        this.role = role;
        this.message = message;
        this.approved = approved;
        this.organization = organization;
        this.user = user;
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

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Testimonial organization(Organization organization) {
        setOrganization(organization);
        return this;
    }

    public Testimonial user(User user) {
        setUser(user);
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
        return Objects.equals(id, testimonial.id) && Objects.equals(name, testimonial.name) && Objects.equals(role, testimonial.role) && Objects.equals(message, testimonial.message) && approved == testimonial.approved && Objects.equals(organization, testimonial.organization) && Objects.equals(user, testimonial.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, message, approved, organization, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", role='" + getRole() + "'" +
            ", message='" + getMessage() + "'" +
            ", approved='" + isApproved() + "'" +
            ", organization='" + getOrganization() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}