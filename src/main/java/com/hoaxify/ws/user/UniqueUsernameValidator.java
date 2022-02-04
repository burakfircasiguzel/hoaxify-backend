/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoaxify.ws.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ELOCK2
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    public boolean isValid(String username, ConstraintValidatorContext cvc) {
        User user = userRepository.findByUsername(username);
        if(user != null){
            return false;
        }
        return true;
    }
    
}
