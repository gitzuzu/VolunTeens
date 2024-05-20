package com.example.aswe.volunteens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
    private Long opportunityId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "location", nullable = false) // 'online' or 'location
    private String location;

    @Column(name="status",nullable=false,columnDefinition = "VARCHAR(255) DEFAULT 'pending'")
    private String status;

    @Column(name = "requirements", nullable = false)
    private String requirements;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;


    public Opportunity() {
    }

    public Opportunity( String title, String description, String location, String status, String requirements, Organization organization) {
       
        this.title = title;
        this.description = description;
        this.location = location;
        this.status = status;
        this.requirements = requirements;
        this.organization = organization;
    }

    public Long getOpportunityId() {
        return this.opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Opportunity opportunityId(Long opportunityId) {
        setOpportunityId(opportunityId);
        return this;
    }

    public Opportunity title(String title) {
        setTitle(title);
        return this;
    }

    public Opportunity description(String description) {
        setDescription(description);
        return this;
    }

    public Opportunity location(String location) {
        setLocation(location);
        return this;
    }

    public Opportunity status(String status) {
        setStatus(status);
        return this;
    }

    public Opportunity requirements(String requirements) {
        setRequirements(requirements);
        return this;
    }

    public Opportunity organization(Organization organization) {
        setOrganization(organization);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Opportunity)) {
            return false;
        }
        Opportunity opportunity = (Opportunity) o;
        return Objects.equals(opportunityId, opportunity.opportunityId) && Objects.equals(title, opportunity.title) && Objects.equals(description, opportunity.description) && Objects.equals(location, opportunity.location) && Objects.equals(status, opportunity.status) && Objects.equals(requirements, opportunity.requirements) && Objects.equals(organization, opportunity.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opportunityId, title, description, location, status, requirements, organization);
    }

    @Override
    public String toString() {
        return "{" +
            " opportunityId='" + getOpportunityId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", location='" + getLocation() + "'" +
            ", status='" + getStatus() + "'" +
            ", requirements='" + getRequirements() + "'" +
            ", organization='" + getOrganization() + "'" +
            "}";
    }

}
