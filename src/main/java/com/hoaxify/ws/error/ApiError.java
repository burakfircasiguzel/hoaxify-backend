/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoaxify.ws.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.hoaxify.ws.shared.Views;
import java.util.Date;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author ELOCK2
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    
    @JsonView(Views.Base.class)
    private int status;
    
    @JsonView(Views.Base.class)
    private String message;
    
    @JsonView(Views.Base.class)
    private String path;
    
    @JsonView(Views.Base.class)
    private long timestamp = new Date().getTime();
    
    private Map<String, String> validitionErrors;

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
        
}
