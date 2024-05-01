package com.example.aswe.volunteens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long organizationId;

    @Column(name = "organization Name", nullable = false)
    private String organizationName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "Description", nullable = false)
    private String organizationDescrp;

    @Column(name = "ContactInfo", nullable = false)
    private String contactInfo;

    @Column(name = "Status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'pending'")
    private String status;
    
    public Organization() {
    }

    public Organization(Long organizationId, String organizationName, String organizationDescrp, String contactInfo, String status) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.organizationDescrp = organizationDescrp;
        this.contactInfo = contactInfo;
        this.status = status;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescrp() {
        return this.organizationDescrp;
    }

    public void setOrganizationDescrp(String organizationDescrp) {
        this.organizationDescrp = organizationDescrp;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Organization organizationId(Long organizationId) {
        setOrganizationId(organizationId);
        return this;
    }

    public Organization organizationName(String organizationName) {
        setOrganizationName(organizationName);
        return this;
    }

    public Organization organizationDescrp(String organizationDescrp) {
        setOrganizationDescrp(organizationDescrp);
        return this;
    }

    public Organization contactInfo(String contactInfo) {
        setContactInfo(contactInfo);
        return this;
    }

    public Organization status(String status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) o;
        return Objects.equals(organizationId, organization.organizationId) && Objects.equals(organizationName, organization.organizationName) && Objects.equals(organizationDescrp, organization.organizationDescrp) && Objects.equals(contactInfo, organization.contactInfo) && Objects.equals(status, organization.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, organizationName, organizationDescrp, contactInfo, status);
    }

    @Override
    public String toString() {
        return "{" +
            " organizationId='" + getOrganizationId() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", organizationDescrp='" + getOrganizationDescrp() + "'" +
            ", contactInfo='" + getContactInfo() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

    
}
