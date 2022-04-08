package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    static void setDifficulty() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Set difficulty
        HashMap<String, String> difficulty = new HashMap<>();
        difficulty.put("e", "easy");
        difficulty.put("n", "normal");
        difficulty.put("h", "hard");
        difficulty.put("o", "oracle");

        HashMap<String, Integer> numbGuesses = new HashMap<>();
        numbGuesses.put("e", 10);
        numbGuesses.put("n", 8);
        numbGuesses.put("h", 6);
        numbGuesses.put("o", 1);

        do {
            System.out.print(Content.askForDifficulty);
            input = scanner.nextLine().toLowerCase();
        } while (!input.matches("[enho]"));

        System.out.printf(Content.showNumbGuesses, difficulty.get(input), numbGuesses.get(input));
    }
}