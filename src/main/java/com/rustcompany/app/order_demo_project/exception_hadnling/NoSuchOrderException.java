package com.rustcompany.app.order_demo_project.exception_hadnling;

public class NoSuchOrderException extends RuntimeException{

    public NoSuchOrderException(String message) {
        super(message);
    }
}
