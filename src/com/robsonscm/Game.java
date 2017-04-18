package com.robsonscm;

import java.util.*;
import java.io.*

public class Game {
    
    public int totalGuesses;
    
    private String input;
    private MyRandomNumber rNumber;
    
    public Game () {
        this.totalGuesses = 0;
        this.input = "";
        this.rNumber = new MyRandomNumber();
    }
    
    public static short ShowMenu() {
    
        short selection;
        Scanner input = new Scanner(System.in);
    
        try {
        
        } catch (Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        clearScreen();
        
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Easy  : Guess a number between 1 and 20");
        System.out.println("2 - Normal: Guess a number between 1 and 100");
        System.out.println("3 - Hard  : Guess a number between 1 and 1000");
        System.out.println("0 - Exit");
        System.out.println("-------------------------\n");
    
        selection = ((short) input.nextInt());
        return selection;
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
