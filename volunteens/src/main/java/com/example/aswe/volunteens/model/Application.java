package com.example.aswe.volunteens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long applicationId;

    @Column(name = "state", nullable = false) //accepted, rejected, pending
    private String state;

    @Column(name = "acadamicGrade", nullable = false) 
    private String acadamicGrade;

    @Lob
    @Column(name = "cv", nullable = false,columnDefinition="LONGBLOB")
    private byte[] cv;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "opportunity_id", nullable = false)
    private Opportunity opportunity;


    public Application() {
    }

    public Application( String state, String acadamicGrade, byte[] cv, User user, Opportunity opportunity) {
        
        this.state = state;
        this.acadamicGrade = acadamicGrade;
        this.cv = cv;
        this.user = user;
        this.opportunity = opportunity;
    }

    public Long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAcadamicGrade() {
        return this.acadamicGrade;
    }

    public void setAcadamicGrade(String acadamicGrade) {
        this.acadamicGrade = acadamicGrade;
    }

    public byte[] getCv() {
        return this.cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Opportunity getOpportunity() {
        return this.opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public Application applicationId(Long applicationId) {
        setApplicationId(applicationId);
        return this;
    }

    public Application state(String state) {
        setState(state);
        return this;
    }

    public Application acadamicGrade(String acadamicGrade) {
        setAcadamicGrade(acadamicGrade);
        return this;
    }

    public Application cv(byte[] cv) {
        setCv(cv);
        return this;
    }

    public Application user(User user) {
        setUser(user);
        return this;
    }

    public Application opportunity(Opportunity opportunity) {
        setOpportunity(opportunity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Application)) {
            return false;
        }
        Application application = (Application) o;
        return Objects.equals(applicationId, application.applicationId) && Objects.equals(state, application.state) && Objects.equals(acadamicGrade, application.acadamicGrade) && Objects.equals(cv, application.cv) && Objects.equals(user, application.user) && Objects.equals(opportunity, application.opportunity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, state, acadamicGrade, cv, user, opportunity);
    }

    @Override
    public String toString() {
        return "{" +
            " applicationId='" + getApplicationId() + "'" +
            ", state='" + getState() + "'" +
            ", acadamicGrade='" + getAcadamicGrade() + "'" +
            ", cv='" + getCv() + "'" +
            ", user='" + getUser() + "'" +
            ", opportunity='" + getOpportunity() + "'" +
            "}";
    }
   
}