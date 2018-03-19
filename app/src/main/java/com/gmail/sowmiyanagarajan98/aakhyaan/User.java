package com.gmail.sowmiyanagarajan98.aakhyaan;

/**
 * Created by Sowmiya Nagarajan on 18-03-2018.
 */

public class User {

    // Bullet basics
    private String address;
    private long dob;
    private String email;
    private String name;

    // Default constructor required by Firebase
    public User() {

    }

    //Constructor
    public User(String address, long dob, String email, String name) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.name = name;
    }

    //Getters
    public String getAddress() {
        return address;
    }

    public String getDob() {
        return String.valueOf(dob);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}