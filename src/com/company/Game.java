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

    static void guessesLeft() {
        if (numbGuesses == 0) {
            resetGame();
        }
        System.out.printf(Content.showGuessesLeft, numbGuesses);
    }

    static void evaluateGuess(String input) {
        if (Word.guessedLettersMap.get(input) == null) {
            numbGuesses -= 1;
        }
        guessesLeft();
    }

    static void play() {
        guessesLeft();
        System.out.println(Content.askForGuess);
    }

    static void resetGame(){
        System.out.println(Content.askForNewGame);
    }
}