package com.robsonscm;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        short userChoice;
        Game game = new Game();
        Scanner input = new Scanner(System.in);

        do {
            
            userChoice = game.DisplayMenu();
            System.out.println(userChoice);
            
            if (userChoice != 0) {
//                game.clearScreen();
                game.PlayGame(userChoice);
            }
            
            System.out.println("Total guesses till final answer: ".concat(Integer.toString(game.totalGuesses)));

        } while (userChoice != 0);
    
        
    }
}
