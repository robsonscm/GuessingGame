package com.robsonscm;

import java.util.*;

public final class MyRandomNumber extends RandomNumber {
    
    protected int minimum; // this field represents the lowest number the random object should create
    protected int maximum; // this field represents the highest number the random object should create
    
    
    public MyRandomNumber() {
        this.SetMinimum(1);
        this.SetMaximum(10);
    }
    
    public MyRandomNumber(int min, int max) {
        this.SetMinimum(min);
        this.SetMaximum(max);
    }
    
    //getters
    public int GetMinimum() {return this.minimum;}
    public int GetMaximum() {return this.maximum;}

    //setters
    public void SetMinimum(int min) {
        this.minimum = min;
    }
    
    public void SetMaximum(int max) {
        this.maximum = max;
    }
    
    @Override
    public int generateRandomNumber() {
        
        if (this.minimum == this.maximum) {
            return this.minimum;
        }
        
        if (this.minimum > this.maximum) {
            int temp = this.maximum;
            this.maximum = this.minimum;
            this.minimum = temp;
        }
        
        currentRandomNumber = random.nextInt(this.maximum) + this.minimum;
        return currentRandomNumber;
    }
    
}
