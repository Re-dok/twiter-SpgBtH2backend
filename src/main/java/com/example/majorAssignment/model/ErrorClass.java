package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorClass {
    String error;

    public ErrorClass(@JsonProperty String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
