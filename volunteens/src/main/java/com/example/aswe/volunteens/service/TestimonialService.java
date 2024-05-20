package com.example.aswe.volunteens.service;

import com.example.aswe.volunteens.dto.TestimonialDTO;
import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.Testimonial;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.TestimonialRepository;

import jakarta.servlet.http.HttpSession;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    public Testimonial saveTestimonial(Testimonial testimonial ,HttpSession session) {
        Organization organization = (Organization) session.getAttribute("org");
        User user = (User) session.getAttribute("user");
        if (organization == null) {
            organization = new Organization();
            organization.setOrganizationId(0L); // Set organization ID to 0
        }

        if (user == null) {
            user = new User();
            user.setUserId(0L); // Set user ID to 0
        }

        Testimonial newTestimonial = new Testimonial(
            testimonial.getName(),
            testimonial.getRole(),
            testimonial.getMessage(),
            false,
            organization,
            user
        );

        return testimonialRepository.save(newTestimonial);
    }
       
      
       
    

    public void deleteTestimonialById(Long id) {
        testimonialRepository.deleteById(id);
    }

    public void approveTestimonial(Long id) {
        Optional<Testimonial> optionalTestimonial = testimonialRepository.findById(id);
        if (optionalTestimonial.isPresent()) {
            Testimonial testimonial = optionalTestimonial.get();
            testimonial.setApproved(true);
            testimonialRepository.save(testimonial);
        } else {
            throw new IllegalArgumentException("Testimonial not found with ID: " + id);
        }
    }
}
