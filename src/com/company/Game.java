package com.company;

import java.util.*;

public class Game {
    static int numbGuesses;

    static void setDifficulty() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Set difficulty
        HashMap<String, String> difficultyMap = new HashMap<>();
        difficultyMap.put("e", "easy");
        difficultyMap.put("n", "normal");
        difficultyMap.put("h", "hard");
        difficultyMap.put("o", "oracle");

        HashMap<String, Integer> numbGuessesMap = new HashMap<>();
        numbGuessesMap.put("e", 10);
        numbGuessesMap.put("n", 8);
        numbGuessesMap.put("h", 6);
        numbGuessesMap.put("o", 1);

        do {
            System.out.print(Content.askForDifficulty);
            input = scanner.nextLine().toLowerCase();
        } while (!input.matches("[enho]"));

        numbGuesses = numbGuessesMap.get(input);
        System.out.printf(Content.showDifficultyToNumbGuesses, difficultyMap.get(input), numbGuesses);
    }
    


    static int guessesLeft() {
        return numbGuesses;
    }
}