package com.github.ripmyskill.model;

public class User {
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;

    public User(String userId, String password, String name, String phoneNumber){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() { return userId; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
}
