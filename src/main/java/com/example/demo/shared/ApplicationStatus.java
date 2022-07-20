package com.example.demo.shared;

public enum ApplicationStatus {

    APPLIED("Applied to university"),NOT_APPLIED("not applied to a university");

    String status;

    ApplicationStatus(String status){
        this.status=status;
    }
}
