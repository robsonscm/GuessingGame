package com.robsonscm;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        short userChoice;
        Game game = new Game();
        
        Scanner input = new Scanner(System.in);
        userChoice = game.DisplayMenu();
        
        System.out.println(userChoice);
    }
}
