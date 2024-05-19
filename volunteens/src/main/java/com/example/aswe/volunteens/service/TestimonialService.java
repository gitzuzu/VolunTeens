package com.example.aswe.volunteens.service;

import com.example.aswe.volunteens.model.Testimonial;
import com.example.aswe.volunteens.respository.TestimonialRepository;
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

    public Testimonial saveTestimonial(Testimonial testimonial) {
        return testimonialRepository.save(testimonial);
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
