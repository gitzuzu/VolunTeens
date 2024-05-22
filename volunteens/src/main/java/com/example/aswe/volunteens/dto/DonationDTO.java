package com.example.aswe.volunteens.dto;
import java.time.LocalDate;
import java.util.Objects;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DonationDTO {
    private Long donationId;
    private String amountDonated;
    @NotBlank(message = "Enter your name")
    private String name;
    private LocalDate donationDate;
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email address")
    private String userEmail;
    private Long orgId;


    public DonationDTO() {
    }

    public DonationDTO(Long donationId, String amountDonated, String name, LocalDate donationDate, String userEmail, Long orgId) {
        this.donationId = donationId;
        this.amountDonated = amountDonated;
        this.name = name;
        this.donationDate = donationDate;
        this.userEmail = userEmail;
        this.orgId = orgId;
    }

    public Long getDonationId() {
        return this.donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public String getAmountDonated() {
        return this.amountDonated;
    }

    public void setAmountDonated(String amountDonated) {
        this.amountDonated = amountDonated;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDonationDate() {
        return this.donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public DonationDTO donationId(Long donationId) {
        setDonationId(donationId);
        return this;
    }

    public DonationDTO amountDonated(String amountDonated) {
        setAmountDonated(amountDonated);
        return this;
    }

    public DonationDTO name(String name) {
        setName(name);
        return this;
    }

    public DonationDTO donationDate(LocalDate donationDate) {
        setDonationDate(donationDate);
        return this;
    }

    public DonationDTO userEmail(String userEmail) {
        setUserEmail(userEmail);
        return this;
    }

    public DonationDTO orgId(Long orgId) {
        setOrgId(orgId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DonationDTO)) {
            return false;
        }
        DonationDTO donationDTO = (DonationDTO) o;
        return Objects.equals(donationId, donationDTO.donationId) && Objects.equals(amountDonated, donationDTO.amountDonated) && Objects.equals(name, donationDTO.name) && Objects.equals(donationDate, donationDTO.donationDate) && Objects.equals(userEmail, donationDTO.userEmail) && Objects.equals(orgId, donationDTO.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationId, amountDonated, name, donationDate, userEmail, orgId);
    }

    @Override
    public String toString() {
        return "{" +
            " donationId='" + getDonationId() + "'" +
            ", amountDonated='" + getAmountDonated() + "'" +
            ", name='" + getName() + "'" +
            ", donationDate='" + getDonationDate() + "'" +
            ", userEmail='" + getUserEmail() + "'" +
            ", orgId='" + getOrgId() + "'" +
            "}";
    }


    

}
