package com.github.ripmyskill.model;

public class User {
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private boolean isAdmin;

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
