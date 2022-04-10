package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Game start
        System.out.println(Content.startGame);
        Game.setDifficulty();

        // Generate random word
        Word.generate();
        System.out.println(Word.secretWord);
        System.out.printf(Content.showWordLength, Word.secretWord.length());

        // Ask for guess
        System.out.printf(Content.showGuessesLeft, Game.guessesLeft());
//        System.out.println(Content.askForGuess);
        Word.printPlaceholders(Word.secretWord);
    }
}
