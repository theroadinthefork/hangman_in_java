package com.company;

import java.util.*;

public class Game {
    static int numbGuesses;
    static Scanner scanner = new Scanner(System.in);

    static void setDifficulty() {
//        Scanner scanner = new Scanner(System.in);
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
        if (numbGuesses == 0) {
            System.out.println(Content.showOutOfGuesses);
            System.out.println(Content.gameOver);
            resetGame();
        }
        return numbGuesses;
    }

    static void evaluateGuess(String input) {
        //Check if they guessed the word
        if (input.equals(Word.secretWord)) {
            System.out.println(Content.endGame);
            for (char l : Word.secretWord.toCharArray()) {
                System.out.print(" " + l + " ");
            }
            System.out.println("\n");
            numbGuesses = 0;
            System.out.println(Content.gameOver);
            return;
        }

        //Check if they guessed a letter
        if (Word.guessedLettersMap.get(input) == null) {
            numbGuesses -= 1;
            System.out.printf(Content.showWrongGuess, input);
        } else if (Word.guessedLettersMap.get(input)) {
            System.out.printf(Content.showAlreadyGuessed, input);
        } else {
            System.out.printf(Content.showCorrectGuess, input);
            Word.guessedLettersMap.put(input, true);
        }
    }

    static void resetGame(){
        String choice = "";
        while (!choice.equals("y") && !choice.equals("n")) {
            System.out.println(Content.askForNewGame);
            choice = scanner.nextLine().toLowerCase();
        }
        if (choice.equals("y")) {
            setupNewGame();
            play();
        } else {
            System.out.println(Content.bye);
        }
    }

    static void setupNewGame() {
        System.out.println(Content.startGame);
        Game.setDifficulty();
        Word.generate();
        System.out.printf(Content.showWordLength, Word.secretWord.length());
    }

    // Gameplay
    static void play() {
        while (numbGuesses != 0) {
            System.out.printf(Content.showGuessesLeft, guessesLeft());
            Word.printGuessedLetters(Word.secretWord);
            System.out.print(Content.askForGuess);
            String guess = scanner.nextLine().toLowerCase();
            evaluateGuess(guess);
        }

        resetGame();
    }
}
