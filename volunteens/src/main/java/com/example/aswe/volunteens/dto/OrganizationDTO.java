package com.example.aswe.volunteens.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

public class OrganizationDTO {
    private Long organizationId;

    @NotBlank(message = "Enter Organization Name")
    private String organizationName;

    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Enter your password")
    @Length(min=8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "Re-enter your password")
    private String cpassword; 

    @NotBlank(message = "Enter your Description")
    private String organizationDescrp;

    @NotBlank(message = "Enter your ContactInfo")
    private String contactInfo;


    public OrganizationDTO() {
    }

    public OrganizationDTO( String organizationName, String email, String password, String cpassword, String organizationDescrp, String contactInfo) {
        this.organizationName = organizationName;
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
        this.organizationDescrp = organizationDescrp;
        this.contactInfo = contactInfo;
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

    public OrganizationDTO organizationId(Long organizationId) {
        setOrganizationId(organizationId);
        return this;
    }

    public OrganizationDTO organizationName(String organizationName) {
        setOrganizationName(organizationName);
        return this;
    }

    public OrganizationDTO email(String email) {
        setEmail(email);
        return this;
    }

    public OrganizationDTO password(String password) {
        setPassword(password);
        return this;
    }

    public OrganizationDTO cpassword(String cpassword) {
        setCpassword(cpassword);
        return this;
    }

    public OrganizationDTO organizationDescrp(String organizationDescrp) {
        setOrganizationDescrp(organizationDescrp);
        return this;
    }

    public OrganizationDTO contactInfo(String contactInfo) {
        setContactInfo(contactInfo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrganizationDTO)) {
            return false;
        }
        OrganizationDTO organizationDTO = (OrganizationDTO) o;
        return Objects.equals(organizationId, organizationDTO.organizationId) && Objects.equals(organizationName, organizationDTO.organizationName) && Objects.equals(email, organizationDTO.email) && Objects.equals(password, organizationDTO.password) && Objects.equals(cpassword, organizationDTO.cpassword) && Objects.equals(organizationDescrp, organizationDTO.organizationDescrp) && Objects.equals(contactInfo, organizationDTO.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, organizationName, email, password, cpassword, organizationDescrp, contactInfo);
    }

    @Override
    public String toString() {
        return "{" +
            " organizationId='" + getOrganizationId() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", cpassword='" + getCpassword() + "'" +
            ", organizationDescrp='" + getOrganizationDescrp() + "'" +
            ", contactInfo='" + getContactInfo() + "'" +
            "}";
    }
   

   
}
