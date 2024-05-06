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
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long feedbackId;

    @Column(name = "feedbackMessage", nullable = false)
    private String feedbackMessage;

    @Column(name = "state", nullable = false)
    private Boolean state; // 0 rejected or havent been revised by admin yet , 1 accepted

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Feedback() {
    }

    public Feedback(Long feedbackId, String feedbackMessage, Boolean state, Organization organization, User user) {
        this.feedbackId = feedbackId;
        this.feedbackMessage = feedbackMessage;
        this.state = state;
        this.organization = organization;
        this.user = user;
    }

    public Long getFeedbackId() {
        return this.feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackMessage() {
        return this.feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public Boolean isState() {
        return this.state;
    }

    public Boolean getState() {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
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

    public Feedback feedbackId(Long feedbackId) {
        setFeedbackId(feedbackId);
        return this;
    }

    public Feedback feedbackMessage(String feedbackMessage) {
        setFeedbackMessage(feedbackMessage);
        return this;
    }

    public Feedback state(Boolean state) {
        setState(state);
        return this;
    }

    public Feedback organization(Organization organization) {
        setOrganization(organization);
        return this;
    }

    public Feedback user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) o;
        return Objects.equals(feedbackId, feedback.feedbackId) && Objects.equals(feedbackMessage, feedback.feedbackMessage) && Objects.equals(state, feedback.state) && Objects.equals(organization, feedback.organization) && Objects.equals(user, feedback.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId, feedbackMessage, state, organization, user);
    }

    @Override
    public String toString() {
        return "{" +
            " feedbackId='" + getFeedbackId() + "'" +
            ", feedbackMessage='" + getFeedbackMessage() + "'" +
            ", state='" + isState() + "'" +
            ", organization='" + getOrganization() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

  }
