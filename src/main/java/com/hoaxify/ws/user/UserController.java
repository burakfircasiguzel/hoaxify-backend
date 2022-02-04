/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoaxify.ws.user;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ELOCK2
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        ApiError error = new ApiError(400, "Validition error", "/users");
        Map<String, String> validitionErrors = new HashMap<>();
        String username = user.getUsername();
        String displayName = user.getDisplayName();
        if (username == null || username.isEmpty()) {
            validitionErrors.put("username", "Username cannot be null");
        }
        if (displayName == null || displayName.isEmpty()) {
            validitionErrors.put("displayName", "Displayname cannot be null");
        }
        if (validitionErrors.size() > 0) {
            error.setValiditionErrors(validitionErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        userService.save(user);
        return ResponseEntity.ok(new GenericResponse("user created"));
    }
    
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiError handleValiditionException(MethodArgumentNotValidException exception){
//        ApiError error = new ApiError(400, "Validition error", "/users");
//        Map<String,String> validitionErrors = new HashMap<>();
//        for(FieldError fieldError: exception.getFieldErrors()){
//            validitionErrors.put(fieldError.getField(), fieldError.getDefaultMessage());       
//        }
//        error.setValiditionErrors(validitionErrors);
//        return error;
//    }
}
