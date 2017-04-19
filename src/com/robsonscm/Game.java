package com.robsonscm;

import java.util.*;
import java.io.*;

public class Game {
    
    public int totalGuesses;
    
    private String input;
    private MyRandomNumber rNumber;
    
    public Game () {
        this.totalGuesses = 0;
        this.input = "";
        this.rNumber = new MyRandomNumber();
    }
    
    public short DisplayMenu() {
    
        boolean done = false;
        short selection = 100;
        Scanner inOption = new Scanner(System.in);

        clearScreen();
        System.out.println("-----------------------------------------------------");
        System.out.println("|        ***  Choose from these choices   ***       |");
        System.out.println("-----------------------------------------------------");
        System.out.println("|  1 - Easy  : Guess a number between 1 and 20      |");
        System.out.println("-----------------------------------------------------");
        System.out.println("|  2 - Normal: Guess a number between 1 and 100     |");
        System.out.println("-----------------------------------------------------");
        System.out.println("|  3 - Hard  : Guess a number between 1 and 1000    |");
        System.out.println("-----------------------------------------------------");
        System.out.println("|  0 - Exit                                         |");
        System.out.println("-----------------------------------------------------");
        System.out.println("\n > ");
    
        while (!done) {
            try {
                selection = ((short) inOption.nextInt());
    
                done = (selection >= 0 && selection <= 3);
                
                if (!done) {
                    throw new Exception("Please enter 0, 1, 2 or 3:");
                }
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.out.println("\n > ");
            }
        }
        
        return this.GameSetup(selection);
    }
    
    public void clearScreen() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (System.getProperty("os.name").startsWith("Window")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException e) {
            for (int i = 0; i < 1000; i++) {
                System.out.println();
            }
        }
    }
    
    private short GameSetup(short option) {
        
        switch (option){
            case 0:
                return option;
            case 1:
                rNumber.setMaximum(20);
                break;
            case 2:
                rNumber.setMaximum(100);
                break;
            case 3:
                rNumber.setMaximum(1000);
                break;
            default:
                this.DisplayMenu();
                return -1;
        }
        rNumber.setMinimum(1);
        return (short) rNumber.generateRandomNumber();
    }
    
    public void PlayGame(short inNumber) {
        
        boolean right = false;
        
        while (!right) {
            try {
                
                if (!right) {
                    this.clearScreen();
                    throw new Exception("Please enter 0, 1, 2 or 3:");
                }
            
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.out.println("\n > ");
            }
        }
    }
}
