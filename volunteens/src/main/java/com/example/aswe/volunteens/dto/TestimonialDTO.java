package com.example.aswe.volunteens.dto;
import java.util.Objects;

public class TestimonialDTO {
    private Long id;
    private String name;
    private String role;
    private String message;
    private boolean approved;
    private Long userId;
    private Long organizationId;


    public TestimonialDTO() {
    }

    public TestimonialDTO(Long id, String name, String role, String message, boolean approved, Long userId, Long organizationId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.message = message;
        this.approved = approved;
        this.userId = userId;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public boolean getApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public TestimonialDTO id(Long id) {
        setId(id);
        return this;
    }

    public TestimonialDTO name(String name) {
        setName(name);
        return this;
    }

    public TestimonialDTO role(String role) {
        setRole(role);
        return this;
    }

    public TestimonialDTO message(String message) {
        setMessage(message);
        return this;
    }

    public TestimonialDTO approved(boolean approved) {
        setApproved(approved);
        return this;
    }

    public TestimonialDTO userId(Long userId) {
        setUserId(userId);
        return this;
    }

    public TestimonialDTO organizationId(Long organizationId) {
        setOrganizationId(organizationId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TestimonialDTO)) {
            return false;
        }
        TestimonialDTO testimonialDTO = (TestimonialDTO) o;
        return Objects.equals(id, testimonialDTO.id) && Objects.equals(name, testimonialDTO.name) && Objects.equals(role, testimonialDTO.role) && Objects.equals(message, testimonialDTO.message) && approved == testimonialDTO.approved && Objects.equals(userId, testimonialDTO.userId) && Objects.equals(organizationId, testimonialDTO.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, message, approved, userId, organizationId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", role='" + getRole() + "'" +
            ", message='" + getMessage() + "'" +
            ", approved='" + isApproved() + "'" +
            ", userId='" + getUserId() + "'" +
            ", organizationId='" + getOrganizationId() + "'" +
            "}";
    }
   
}
