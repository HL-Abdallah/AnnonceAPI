package com.example.annonceapi.exceptions;

public class AnnonceNotFound extends RuntimeException {

    public AnnonceNotFound(String errorMessage) {
        super(errorMessage);
    }

}
