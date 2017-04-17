package com.robsonscm;

import java.util.Random;

public class RandomNumber {
    
    protected Random random;
    protected int currentRandomNumber;
    
    public RandomNumber() {
        currentRandomNumber = 0;
        random = new Random();
    }
    
    public int generateRandomNumber() {
        currentRandomNumber = random.nextInt();
        return currentRandomNumber;
    }
    
    public int getCurrentRandomNumber() {
        return currentRandomNumber;
    }
}