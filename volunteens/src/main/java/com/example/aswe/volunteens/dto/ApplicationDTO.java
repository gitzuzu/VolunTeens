package com.example.aswe.volunteens.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class ApplicationDTO {
    private Long applicationId;
    @NotBlank (message = "Enter your name")
    private String name;
    @NotBlank (message = "Enter your Email")
    private String email;
    @NotBlank (message = "Enter your academic Grade")
    private String academicGrade;
    private Long opportunityId;
    private MultipartFile cv;


    public ApplicationDTO() {
    }

    public ApplicationDTO(Long applicationId, String name, String email, String academicGrade, Long opportunityId, MultipartFile cv) {
        this.applicationId = applicationId;
        this.name = name;
        this.email = email;
        this.academicGrade = academicGrade;
        this.opportunityId = opportunityId;
        this.cv = cv;
    }

    public Long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcademicGrade() {
        return this.academicGrade;
    }

    public void setAcademicGrade(String academicGrade) {
        this.academicGrade = academicGrade;
    }

    public Long getOpportunityId() {
        return this.opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public MultipartFile getCv() {
        return this.cv;
    }

    public void setCv(MultipartFile cv) {
        this.cv = cv;
    }

    public ApplicationDTO applicationId(Long applicationId) {
        setApplicationId(applicationId);
        return this;
    }

    public ApplicationDTO name(String name) {
        setName(name);
        return this;
    }

    public ApplicationDTO email(String email) {
        setEmail(email);
        return this;
    }

    public ApplicationDTO academicGrade(String academicGrade) {
        setAcademicGrade(academicGrade);
        return this;
    }

    public ApplicationDTO opportunityId(Long opportunityId) {
        setOpportunityId(opportunityId);
        return this;
    }

    public ApplicationDTO cv(MultipartFile cv) {
        setCv(cv);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ApplicationDTO)) {
            return false;
        }
        ApplicationDTO applicationDTO = (ApplicationDTO) o;
        return Objects.equals(applicationId, applicationDTO.applicationId) && Objects.equals(name, applicationDTO.name) && Objects.equals(email, applicationDTO.email) && Objects.equals(academicGrade, applicationDTO.academicGrade) && Objects.equals(opportunityId, applicationDTO.opportunityId) && Objects.equals(cv, applicationDTO.cv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, name, email, academicGrade, opportunityId, cv);
    }

    @Override
    public String toString() {
        return "{" +
            " applicationId='" + getApplicationId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", academicGrade='" + getAcademicGrade() + "'" +
            ", opportunityId='" + getOpportunityId() + "'" +
            ", cv='" + getCv() + "'" +
            "}";
    }

    
    
}
