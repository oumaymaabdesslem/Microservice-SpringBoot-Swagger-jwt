package com.example.projectpfa.Exception;

import com.example.projectpfa.restResponse.GenericResponse;
import com.example.projectpfa.restResponse.ResponseBuilder;

public class InvalidCredentialsException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public GenericResponse buildErrorResponse(){
        return ResponseBuilder.buildErrorResponse(403,"Invalid Credentials");
    }
}
