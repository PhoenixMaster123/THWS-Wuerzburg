package org.example;

import java.io.Serializable;

class Response implements Serializable { // New class for server response
    String message; // "OK" or "Error"


    public Response(String message) {
        this.message = message;
    }
}