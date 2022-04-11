package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Word {

    // Get a random word from file and set it as the secret word
    static String generate() {
        String secretWord = "";
        try {
                // Check words.txt file length
                Path path = Paths.get("words.txt");
                long totalLines = Files.lines(path).count();

                // Get random word where the character count is at least 3
                while (secretWord.length() < 3) {
                    Random random = new Random();
                    int lineNumber = random.nextInt((int)totalLines);

                    Stream<String> lines = Files.lines(path);
                    secretWord = lines.skip(lineNumber).findFirst().get();
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }

        return secretWord;
    }

    static HashMap<String, Boolean> mapGuessedLetters (String word) {
        HashMap<String, Boolean> guessedLettersMap = new HashMap<>();
        // Create map with guessed and not guessed letters
        for (char l : word.toCharArray()) {
            guessedLettersMap.put(String.valueOf(l), false);
        }
        return guessedLettersMap;
    }

    static void printGuessedLetters(String word, HashMap<String, Boolean> map) {
        System.out.println("\n");
        for(char l: word.toCharArray()){
            if (map.get(String.valueOf(l))) {
                System.out.print(" " + l + " ");
            } else {
                System.out.print(" _ ");
            }
        }
        System.out.println("\n");
    }
//
//    static void printSecretWord() {
//        for (char l : secretWord.toCharArray()) {
//            System.out.print(" " + l + " ");
//        }
//        System.out.println("\n");
//    }
}
