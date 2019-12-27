package com.bluerei.helloworld.api;

public class Response {
    private String greeting;
    private Status status = Status.OK;

    public Response(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getStatus() {
        return status.name();
    }

}
