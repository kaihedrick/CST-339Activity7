package com.gcu.cst339.model;

public class UserModel {
    private String id;
    private String username;
    private String password;

    // Default constructor
    public UserModel() {
        this.id = "";
        this.username = "";
        this.password = "";
    }

    // Non-default constructor
    public UserModel(String id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
