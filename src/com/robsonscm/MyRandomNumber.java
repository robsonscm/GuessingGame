/**********************************************************************************************************************
 * ======================================================================
 *  SubClass created for the the Project. Has RandomNumber as Super Class
 * ======================================================================
 * Added by: Robson Miranda
 * Date    : April 21, 2017
 * Comments: Basically, control random numbers based on minimum and
 *           maximum values. Uses java.util.Random class
 * ======================================================================
 ***********************************************************************************************************************/
package com.robsonscm;

public final class MyRandomNumber extends RandomNumber {
    
    protected int minimum; // this field represents the lowest number the random object should create
    protected int maximum; // this field represents the highest number the random object should create
    
    //Default Constructor
    public MyRandomNumber() {
        this.SetMinimum(1);  //default min value
        this.SetMaximum(10); //default max value
    }
    
    //Overloaded Constructor. Set min and max as required
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
    
    //Overridden Random Number Generator. It limits values between subclass' fields min and max
    @Override
    public int generateRandomNumber() {
    
        //In case of min and max are equal, returns the minimum
        if (this.minimum == this.maximum) {
            return this.minimum;
        }
        
        //In case of min and max are swapped, swap back before getting the random number
        if (this.minimum > this.maximum) {
            int temp = this.maximum;
            this.maximum = this.minimum;
            this.minimum = temp;
        }
        
        //random number being created between min and max
        currentRandomNumber = random.nextInt(this.maximum) + this.minimum;
        return currentRandomNumber;
    }
    
}
