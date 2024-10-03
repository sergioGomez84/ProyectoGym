package org.accenture.proyecto.gym.classAndTrainerManagement.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
