package com.robsonscm;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        short userChoice;
        Game game = new Game();
        Scanner inOption = new Scanner(System.in);
        String input;
    
        do {
            
            userChoice = game.DisplayMenu();
            System.out.println(userChoice);
            
            if (userChoice != 0) {
                game.PlayGame(userChoice);
                System.out.println("You guessed ".concat(Integer.toString(game.totalGuesses).concat(" time(s) to find it out!")));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                System.out.println("#####################################################");
                System.out.println("#     To leave the game press n and then ENTER      #");
                System.out.println("#            or just ENTER to Play Again            #");
                System.out.println("#####################################################");
                input = inOption.nextLine();
                
                if (input.equals("n") || input.equals("N")) {
                    userChoice = 0;
                }
            }

        } while (userChoice != 0);
        System.out.println("Thank you for playing!");
        System.out.println("See ya!!");
    
    }
}
