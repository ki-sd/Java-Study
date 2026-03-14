package com.github.ripmyskill.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    @JsonProperty("admin")
    private boolean isAdmin;

    public User() {}

    public User(String userId, String password, String name, String phoneNumber, boolean isAdmin){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    public String getUserId() { return userId; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public boolean isAdmin() { return isAdmin; }
}
