package com.gmail.sowmiyanagarajan98.aakhyaan;

/**
 * Created by Sowmiya Nagarajan on 18-03-2018.
 */

public class Counts {

    // Bullet basics
    private long user;
    private long bla;

    // Default constructor required by Firebase
    public Counts() {

    }

    //Constructor
    public Counts(long user, long bla) {
        this.user = user;
        this.bla = bla;
    }

    //Getters
    public long getUser() {
        return user;
    }

    public long getBla() {
        return bla;
    }

}