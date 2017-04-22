/**********************************************************************************************************************
 * ======================================================================
 *  Game Class created for the the Project. Has all the game requirements
 * ======================================================================
 * Added by: Robson Miranda
 * Date    : April 21, 2017
 * Comments: Basically:
 *           - display menu and check game mode selection
 *           - clear screen (java doesn't handle very well it, so it adds
 *             a bunch of lines and set return at the bottom of the page
 *           - set up the game according with the mode selected
 *           - do all the game logic and treatment
 * ======================================================================
 ***********************************************************************************************************************/
package com.robsonscm;

import java.util.*;

public class Game {
    
    public int totalGuesses;         //variable to store user's total of guesses
    
    private String input;            //variable to handle terminal input
    private MyRandomNumber rNumber;  //variable to instance a new MyRandomNumber object
    
    //Default Constructor
    public Game () {
        this.totalGuesses = 0;                //start at 0 guesses
        this.input = "";                      //start empty
        this.rNumber = new MyRandomNumber();  //instance new object
    }
    
    //Display main menu with game's modes
    public short DisplayMenu() {
    
        boolean isDone = false;                     //control appropriate options chosen
        int selection = -1;                         //-1 represents beginning of the game
        Scanner inOption = new Scanner(System.in);  //initiate input reading from terminal
        
        this.clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║        ###  Choose from these choices   ###       ║");
        System.out.println("╠═════╦═════════════════════════════════════════════╣");
        System.out.println("║  1  ║ Easy  : Guess a number between 1 and 20     ║");
        System.out.println("╠═════╬═════════════════════════════════════════════╣");
        System.out.println("║  2  ║ Normal: Guess a number between 1 and 100    ║");
        System.out.println("╠═════╬═════════════════════════════════════════════╣");
        System.out.println("║  3  ║ Hard  : Guess a number between 1 and 1000   ║");
        System.out.println("╠═════╬═════════════════════════════════════════════╣");
        System.out.println("║  0  ║ Exit                                        ║");
        System.out.println("╚═════╩═════════════════════════════════════════════╝");
        System.out.print("> ");
    
        //while not a valid choice, keep looping
        while (!isDone) {
            try {
                //read terminal input
                selection = (inOption.nextInt());
                //check if it is a valid option
                isDone = (selection >= 0 && selection <= 3);
                //if not ok, throw controlled exception
                if (!isDone) {
                    throw new Exception("Please enter 0, 1, 2 or 3: ");
                }
            } catch (InputMismatchException e) {
                //in case of not typing a digit, give err message and ask new guess
                selection = 0;
                System.err.println(inOption.next() + " was not valid input. Try again: ");
            } catch (Exception e) {
                //handle controlled exception
                System.err.println(e.getMessage());
            }
        }
        //when having valid option, call GameSetup method with the chosen option
        return this.GameSetup( (short) selection);
    }
    
    //clear screen
    // IMPORTANT *** Windows works fine, but Mac is just printing blank lines as workaround *** IMPORTANT
    public void clearScreen() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                System.out.println("** cls **");
                System.out.println("\f");
                System.out.println("\f");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                System.out.println("** clear **");
                System.out.println("\f");
                System.out.println("\f");
                for (int i = 0; i < 1000; i++) {
                    System.out.println();
                }
                //Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            for (int i = 0; i < 1000; i++) {
                System.out.println();
            }
        }
    }
    
    //Set up the game with min and max values and return the secret number
    private short GameSetup(short option) {
        
        switch (option){
            case 0:
                return option;
            case 1:
                rNumber.SetMaximum(20);     //20 is the max for Game Mode 1
                break;
            case 2:
                rNumber.SetMaximum(100);    //100 is the max for Game Mode 1
                break;
            case 3:
                rNumber.SetMaximum(1000);   //1000 is the max for Game Mode 1
                break;
            default:
                this.DisplayMenu();         //in case of some different value passes, menu is called again
                return -1;
        }
        rNumber.SetMinimum(1);              // min value is always 1 for this game
        
        //return a short Secret Number to be guessed
        return (short) rNumber.generateRandomNumber();
    }
    
    //This Method controls all the game interactions. I provides tips according to the guess given
    public void PlayGame(short inNumber) {
        
        boolean isRight = false;                    //control if the guess is right
    
        Scanner inOption = new Scanner(System.in);  //initiate new object to read input values
        
        this.clearScreen();                         //clear the screen
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║       ###  To leave the game press X   ###        ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        
        //while is not the righe guess, os X is not pressed, continues looping
        while (!isRight) {
            try {
                
                this.totalGuesses++;                        //increment number of tried guesses
    
                System.out.println("Type your guess: ");
                System.out.print("> ");
    
                short guess = 0;                            //initiate guess as 0
                input = inOption.nextLine();
                
                //if input is x, user wants to exit game. Else, input guess is checked with Secret Number
                if (input.equals("x") || input.equals("X")) {
                    break;
                } else {
                    guess = Short.parseShort(input);    //get input guess
                    isRight = (inNumber == guess);      //set isRight true or false according to the guess
                }
                
                //if not the right number, clear screen, give a hint, and start the process again
                if (!isRight) {
                    clearScreen();
                    System.out.println("╔═════════════════════════════════════════════════════════╗");
                    System.out.println(this.checkNumber(inNumber, guess));
                    System.out.println("╚═════════════════════════════════════════════════════════╝");
                }
    
            } catch (NumberFormatException | InputMismatchException e) {
                //in case of guess not a digit, raise a message error
                System.out.println(input + " was not valid input. Try again. ");
            }
        }
    
        //game is over. Stringify Secret Number to reveal on terminal
        String myNumber = Integer.toString(rNumber.getCurrentRandomNumber());
        this.clearScreen();
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║             Thank you for playing!                ║");
        System.out.println("║            The Magic number was " + padLeft(myNumber, 4) + "              ║");
    }
    
    //this method controls how close the guess is to the Secret Number
    private String checkNumber(short num, short bet) {
        
        float perc = (float) bet/num;
        return (perc > 1)
            ?
            ((perc-1 < 0.33f) ? "║ =====>>>>  So close! A little bit down!                 ║" :
             (perc-1 < 0.66f) ? "║ =====>>>>  Almost there! Guess a lower number.          ║" :
                                "║ =====>>>>  Too high!! Try miles below it!!!!            ║")
            :
             (perc   < 0.33f) ? "║ =====>>>>  So low!! Think Bigger!!!!!                   ║" :
             (perc   < 0.66f) ? "║ =====>>>>  Half-way there. A larger number would work!! ║" :
                                "║ =====>>>>  Getting Hot here! Guess a bit up!            ║";
    }
    
    //this method pad elements with spaces
    public static String padLeft(String str, int n) {
        return String.format("%1$" + n + "s", str);
        //.replace(' ', '0')
    }
}
