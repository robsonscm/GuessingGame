package com.robsonscm;

import java.util.*;

public class Main {
    
    private static int ShowMenu() {
        
            int selection;
            Scanner input = new Scanner(System.in);
        
            /***************************************************/
        
            System.out.println("Choose from these choices");
            System.out.println("-------------------------\n");
            System.out.println("1 - Easy  : Guess a number between 1 and 20");
            System.out.println("2 - Normal: Guess a number between 1 and 100");
            System.out.println("3 - Hard  : Guess a number between 1 and 1000");
            System.out.println("4 - Exit");
        
            selection = input.nextInt();
            return selection;
    }
    
    public static void main(String[] args) {

        int userChoice;
        Scanner input = new Scanner(System.in);
        userChoice = ShowMenu();
        
        System.out.println(userChoice);
    }
}
