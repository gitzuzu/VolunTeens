package com.example.aswe.volunteens.dto;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class OpportunityDTO {
    private Long opportunityId;
    @NotBlank(message = "Enter the title")
    private String title;
    @NotBlank(message = "Enter the location")
    private String location;
    @NotBlank(message = "Enter the requirements")
    private String requirements;
    @NotBlank(message = "Enter the description")
    private String description;


    public OpportunityDTO() {
    }

    public OpportunityDTO(Long opportunityId, String title, String description, String location, String requirements) {
        this.opportunityId = opportunityId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.requirements = requirements;
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

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public OpportunityDTO opportunityId(Long opportunityId) {
        setOpportunityId(opportunityId);
        return this;
    }

    public OpportunityDTO title(String title) {
        setTitle(title);
        return this;
    }

    public OpportunityDTO description(String description) {
        setDescription(description);
        return this;
    }

    public OpportunityDTO location(String location) {
        setLocation(location);
        return this;
    }

    public OpportunityDTO requirements(String requirements) {
        setRequirements(requirements);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OpportunityDTO)) {
            return false;
        }
        OpportunityDTO opportunityDTO = (OpportunityDTO) o;
        return Objects.equals(opportunityId, opportunityDTO.opportunityId) && Objects.equals(title, opportunityDTO.title) && Objects.equals(description, opportunityDTO.description) && Objects.equals(location, opportunityDTO.location) && Objects.equals(requirements, opportunityDTO.requirements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opportunityId, title, description, location, requirements);
    }

    @Override
    public String toString() {
        return "{" +
            " opportunityId='" + getOpportunityId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", location='" + getLocation() + "'" +
            ", requirements='" + getRequirements() + "'" +
            "}";
    }

   
    
}
