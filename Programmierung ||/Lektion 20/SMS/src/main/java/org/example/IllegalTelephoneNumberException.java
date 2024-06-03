package org.example;

public class IllegalTelephoneNumberException extends Exception {
    public IllegalTelephoneNumberException(char ch) {
        super("Illegal character: " + ch);
        //System.err.println("Illegal character: " + ch);

    }
}
