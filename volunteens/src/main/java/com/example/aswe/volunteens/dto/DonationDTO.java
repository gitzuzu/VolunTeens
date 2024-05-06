package com.example.aswe.volunteens.dto;
import java.time.LocalDate;
import java.util.Objects;

public class DonationDTO {
    private Long donationId;
    private String amountDonated;
    private String userId;
    private LocalDate donationDate;
    private String userEmail;


    public DonationDTO() {
    }

    public DonationDTO(Long donationId, String amountDonated, String userId, LocalDate donationDate, String userEmail) {
        this.donationId = donationId;
        this.amountDonated = amountDonated;
        this.userId = userId;
        this.donationDate = donationDate;
        this.userEmail = userEmail;
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public DonationDTO donationId(Long donationId) {
        setDonationId(donationId);
        return this;
    }

    public DonationDTO amountDonated(String amountDonated) {
        setAmountDonated(amountDonated);
        return this;
    }

    public DonationDTO userId(String userId) {
        setUserId(userId);
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DonationDTO)) {
            return false;
        }
        DonationDTO donationDTO = (DonationDTO) o;
        return Objects.equals(donationId, donationDTO.donationId) && Objects.equals(amountDonated, donationDTO.amountDonated) && Objects.equals(userId, donationDTO.userId) && Objects.equals(donationDate, donationDTO.donationDate) && Objects.equals(userEmail, donationDTO.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationId, amountDonated, userId, donationDate, userEmail);
    }

    @Override
    public String toString() {
        return "{" +
            " donationId='" + getDonationId() + "'" +
            ", amountDonated='" + getAmountDonated() + "'" +
            ", userId='" + getUserId() + "'" +
            ", donationDate='" + getDonationDate() + "'" +
            ", userEmail='" + getUserEmail() + "'" +
            "}";
    }

}
