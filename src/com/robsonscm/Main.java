/**********************************************************************************************************************
 * ======================================================================
 *  Main Class created for the the Project. Present and Control the Game
 * ======================================================================
 * Added by: Robson Miranda
 * Date    : April 21, 2017
 * Comments: Basically:
 *           - Present the game
 *           - Wait for exit command
 *           - show message on the screen
 * ======================================================================
 ***********************************************************************************************************************/
package com.robsonscm;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        short userChoice;                           //receives option chosen by the user
        Game game = new Game();                     //initiate new Game Object
        String input;                               //declare variable to handle input from terminal
        Scanner inOption = new Scanner(System.in);  //initiate new Object to read input from terminal
    
        do {
            //Display menu and wait for user's choice
            userChoice = game.DisplayMenu();
            //if user's choice different from 0, start game
            if (userChoice != 0) {
                game.clearScreen();         //clear screen
                
                // IMPORTANT *** I' passing the number here, as asked in the assignment, but I think we don' need to use it here.
                // IMPORTANT *** Into the PlayGame method it's possible to call rNumber.getCurrentRandomNumber() to check the number.
                game.PlayGame(userChoice);  //call Play Game method passing the Secret Number
                
                System.out.println("║     You guessed " + game.padLeft(Integer.toString(game.totalGuesses),4) + " time(s) to find it out!      ║");
                System.out.println("╠═══════════════════════════════════════════════════╣");
                System.out.println("║             Do you wanna play again??             ║");
                System.out.println("╠═══════════════════════════════════════════════════╣");
                System.out.println("║       Press N to exit or ENTER to Play Again      ║");
                System.out.println("╚═══════════════════════════════════════════════════╝");
                System.out.print("> ");
                
                //Read user's input
                input = inOption.nextLine();
                
                //if input is N, Game Over.
                if (input.equals("n") || input.equals("N")) {
                    userChoice = 0;
                }
            }

        } while (userChoice != 0); //loop until user wants to exit
        
        game.clearScreen(); //clear screen
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║             Thank you for playing!                ║");
        System.out.println("║                     See ya!!                      ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println();
    
    }
}
