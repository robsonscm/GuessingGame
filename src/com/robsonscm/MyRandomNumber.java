package com.robsonscm;

import java.util.Random;

public final class MyRandomNumber extends RandomNumber {
    
    protected int minimum; // this field represents the lowest number the random object should create
    protected int maximum; // this field represents the highest number the random object should create
    
    
    public MyRandomNumber() {
        currentRandomNumber = 0;
        random = new Random();
    }
    
    public MyRandomNumber(Random number) {
        currentRandomNumber = 0;
        random = number;
    }
    
    //getters
    public int getMinimum() {return this.minimum;}
    public int getMaximum() {return this.maximum;}

    //setters
    public boolean setMinimum() {
        return true;
    }
    
    public boolean setMaximum() {
        return true;
    }
    
}
