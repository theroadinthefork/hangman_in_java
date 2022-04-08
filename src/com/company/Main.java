package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Content
        String startGame = "*** Let's play a game of HANGMAN! ***\n";
        String askForDifficulty = "Choose a difficulty level and then hit [enter] key: [e]asy, [n]ormal, [h]ard, [o]racle: ";
        String showNumbGuesses = "With %s difficulty, you'll have %s guesses. Let's start!";

        // Game start
        System.out.println(startGame);
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
            System.out.print(askForDifficulty);
            input = scanner.nextLine().toLowerCase();
        } while (!input.matches("[enho]"));

        System.out.printf(showNumbGuesses, difficulty.get(input), numbGuesses.get(input));

        // Generate random word
        try {
            File words = new File("words.txt");
            Scanner wordReader = new Scanner(words);
            System.out.println(words.length());
            wordReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file words.txt");
            e.printStackTrace();
        }

    }



}
