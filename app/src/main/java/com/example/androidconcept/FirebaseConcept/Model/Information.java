package com.example.androidconcept.FirebaseConcept.Model;

public class Information {
    private String email;
    private String name;

    public Information() {

    }

    public Information(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
