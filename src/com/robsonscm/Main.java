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
                game.PlayGame(userChoice);
            }

        } while (userChoice != 0 /*||
                 Objects.equals(input.next(), "n") ||
                 Objects.equals(input.next(), "N")*/);
    
        
    }
}
