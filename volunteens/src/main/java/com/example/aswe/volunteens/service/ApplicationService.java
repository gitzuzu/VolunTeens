package com.example.aswe.volunteens.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.aswe.volunteens.dto.ApplicationDTO;
import com.example.aswe.volunteens.model.Application;
import com.example.aswe.volunteens.model.Opportunity;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.ApplicationRepository;
import com.example.aswe.volunteens.respository.OpportunityRepository;
import com.example.aswe.volunteens.respository.UserRepositry;
@Service
public class ApplicationService {
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private UserRepositry userRepositry;
    @Autowired
    private ApplicationRepository applicationRepository;
    public void saveApplication(ApplicationDTO applicationDTO) throws IOException{
        MultipartFile file = applicationDTO.getCv();
        if(file!=null){
            byte[] cvBytes = file.getBytes();
            Opportunity opportunity = opportunityRepository.findById(applicationDTO.getOpportunityId()).get();
            User user = userRepositry.findByEmail(applicationDTO.getEmail()) ;
            Application app = new Application("pending",applicationDTO.getAcademicGrade(), cvBytes, user, opportunity);
            applicationRepository.save(app);
        }
    }
}
