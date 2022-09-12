package com.rustcompany.app.order_demo_project.exception_handling;

public class NoSuchOrderException extends RuntimeException{

    public NoSuchOrderException(String message) {
        super(message);
    }
}
