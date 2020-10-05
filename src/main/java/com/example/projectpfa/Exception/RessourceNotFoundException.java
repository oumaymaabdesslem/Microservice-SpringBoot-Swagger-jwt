package com.example.projectpfa.Exception;


import com.example.projectpfa.restResponse.GenericResponse;
import com.example.projectpfa.restResponse.ResponseBuilder;



public class RessourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RessourceNotFoundException(int id) {
        super("Could not find ressource " + id);
    }


}
