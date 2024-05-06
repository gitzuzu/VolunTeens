package com.example.aswe.volunteens.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long donationId;

    @Column(name="amountDonated", nullable = false)
    private String amountDonated;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "donationDate")
    private LocalDate donationDate;

    public Donation() {
    }

    public Donation( String amountDonated, User user, LocalDate donationDate) {
     
        this.amountDonated = amountDonated;
        this.user = user;
        this.donationDate = donationDate;
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDonationDate() {
        return this.donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public Donation donationId(Long donationId) {
        setDonationId(donationId);
        return this;
    }

    public Donation amountDonated(String amountDonated) {
        setAmountDonated(amountDonated);
        return this;
    }

    public Donation user(User user) {
        setUser(user);
        return this;
    }

    public Donation donationDate(LocalDate donationDate) {
        setDonationDate(donationDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Donation)) {
            return false;
        }
        Donation donation = (Donation) o;
        return Objects.equals(donationId, donation.donationId) && Objects.equals(amountDonated, donation.amountDonated) && Objects.equals(user, donation.user) && Objects.equals(donationDate, donation.donationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationId, amountDonated, user, donationDate);
    }

    @Override
    public String toString() {
        return "{" +
            " donationId='" + getDonationId() + "'" +
            ", amountDonated='" + getAmountDonated() + "'" +
            ", user='" + getUser() + "'" +
            ", donationDate='" + getDonationDate() + "'" +
            "}";
    }
}
