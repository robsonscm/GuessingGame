package com.robsonscm;

import java.util.*;

public final class MyRandomNumber extends RandomNumber {
    
    protected int minimum; // this field represents the lowest number the random object should create
    protected int maximum; // this field represents the highest number the random object should create
    protected int[] possibleMax = {20,100,1000};
    
    
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
    public boolean setMinimum(int num) {
        if (num != 1) {
            this.minimum = 1;
            return false;
        }
        this.minimum = num;
        return true;
    }
    
    public boolean setMaximum(int num) {
    
        Arrays.sort(possibleMax);

        for (int n : possibleMax )
        {
            if (n == num)
            {
                this.maximum = num;
                return true;
            }
        }
    
        System.out.println(possibleMax);
        
        for (int max : possibleMax )
        {
            if (num <= max)
            {
                this.maximum = max;
                return false;
            }
        }
    }
    
}
