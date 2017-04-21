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
            
            if (userChoice != 0) {
                game.clearScreen();
                game.PlayGame(userChoice);
                System.out.println("║     You guessed " + game.padLeftZeros(Integer.toString(game.totalGuesses),4) + " time(s) to find it out!      ║");
                System.out.println("╠═══════════════════════════════════════════════════╣");
                System.out.println("║             Do you wanna play again??             ║");
                System.out.println("╠═══════════════════════════════════════════════════╣");
                System.out.println("║       Press N to exit or ENTER to Play Again      ║");
                System.out.println("╚═══════════════════════════════════════════════════╝");
                System.out.print("> ");
                input = inOption.nextLine();
                
                if (input.equals("n") || input.equals("N")) {
                    userChoice = 0;
                }
            }

        } while (userChoice != 0);
        
        game.clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║             Thank you for playing!                ║");
        System.out.println("║                     See ya!!                      ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println();
    
    }
}
