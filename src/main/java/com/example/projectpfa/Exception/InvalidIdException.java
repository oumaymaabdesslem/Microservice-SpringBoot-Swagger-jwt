package com.example.projectpfa.Exception;

import com.example.projectpfa.restResponse.GenericResponse;
import com.example.projectpfa.restResponse.ResponseBuilder;

public class InvalidIdException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    public GenericResponse buildErrorResponse(){
        return ResponseBuilder.buildErrorResponse(100,"Not Result found for the given ID");
    }
}
