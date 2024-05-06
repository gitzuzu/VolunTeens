package com.example.aswe.volunteens.service;



import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.OrganizationRepository;
import com.example.aswe.volunteens.respository.UserRepositry;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {
      @Autowired
    private UserRepositry userRepositry;
    @Autowired
    private OrganizationRepository organizationRepository;

   public boolean getUser (String email,String password,HttpSession session){
        
        User user = this.userRepositry.findByEmail(email);
        if(user!=null && BCrypt.checkpw(password, user.getPassword())){
            session.setAttribute("userId", user.getFirstname());
            session.setAttribute("userEmail", user.getEmail());
            session.removeAttribute("orgId");
            return true;
        }else{
            Organization org = this.organizationRepository.findByEmail(email);
            if(org!=null && BCrypt.checkpw(password, org.getPassword())){
                session.setAttribute("orgId", org.getOrganizationName());
                session.removeAttribute("userId"); 
                return true;
            }
            else{
                return false;
            }
        }
 
      
      
    }
}
 


