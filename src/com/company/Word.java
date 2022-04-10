package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Word {

    static String secretWord = "";
    static List<String> guessedLetters;

    static String generate() {

        try {
                // Check words.txt file length
                Path path = Paths.get("words.txt");
                long totalLines = Files.lines(path).count();

                // Get random word where at the character count is at least 3

                while (secretWord.length() < 3) {
                    Random random = new Random();
                    int lineNumber = random.nextInt((int)totalLines);

                    Stream<String> lines = Files.lines(path);
                    secretWord = lines.skip(lineNumber).findFirst().get();
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] letters = secretWord.split("");
        guessedLetters = new ArrayList<>(Arrays.asList(letters));
        return secretWord;
    }

    static void printPlaceholders(String word){
        for(String s: guessedLetters){
            System.out.print(" _ ");
        }
    }

}
