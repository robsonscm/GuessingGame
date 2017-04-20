package com.robsonscm;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        short userChoice;
        Game game = new Game();
        do {
            
            userChoice = game.DisplayMenu();
            System.out.println(userChoice);
            
            if (userChoice != 0) {
                game.PlayGame(userChoice);
            }
    
            System.out.println("You guessed ".concat(Integer.toString(game.totalGuesses).concat(" time(s) to find it out!")));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } while (userChoice != 0);
    
        
    }
}
