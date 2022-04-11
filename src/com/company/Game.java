package com.company;

import java.util.*;

public class Game {
    int numbGuesses;
    String currentState;
    enum state {WON, LOST, INPLAY};
    enum guessEvaluation {WRONG_WORD, WRONG_LETTER, RIGHT_LETTER, RIGHT_WORD, INVALID_CHARACTER, GUESSED_LETTER}
//    static Scanner scanner = new Scanner(System.in);

    Game (int numbGuesses) {
        this.numbGuesses = numbGuesses;
        this.currentState = String.valueOf(state.INPLAY);
    }

//    static void setDifficulty() {
//        String input = "";
//
//        // Map difficulty to number of guesses
//        HashMap<String, String> difficultyMap = new HashMap<>();
//        difficultyMap.put("e", "easy");
//        difficultyMap.put("n", "normal");
//        difficultyMap.put("h", "hard");
//        difficultyMap.put("o", "oracle");
//
//        HashMap<String, Integer> numbGuessesMap = new HashMap<>();
//        numbGuessesMap.put("e", 12);
//        numbGuessesMap.put("n", 10);
//        numbGuessesMap.put("h", 8);
//        numbGuessesMap.put("o", 1);
//
//        do {
//            System.out.print(Content.askForDifficulty);
//            input = scanner.nextLine().toLowerCase();
//        } while (!input.matches("[enho]"));
//
//        numbGuesses = numbGuessesMap.get(input);
//        System.out.printf(Content.showDifficultyToNumbGuesses, difficultyMap.get(input), numbGuesses);
//    }

    private String gameIsWon() {
        this.numbGuesses = 0;
        return this.currentState = String.valueOf(state.WON);
    }


    String evaluateGuess(String guess, String word, HashMap<String,Boolean> map) {
        //Check if they guessed the word
        if (guess.length() > 1) {
            if (guess.equals(word)) {
                return String.valueOf(guessEvaluation.RIGHT_WORD);
            } else {
                this.numbGuesses -= 1;
                return String.valueOf(guessEvaluation.WRONG_WORD);
            }
        }

        // Check if valid character
        if (guess.matches("[a-zA-Z]")) {

            //Check if they guessed a letter
            if (map.get(guess) == null) {
                this.numbGuesses -= 1;
                return String.valueOf(guessEvaluation.WRONG_LETTER);
            } else if (map.get(guess)) {
                return String.valueOf(guessEvaluation.GUESSED_LETTER);
            } else {
                this.numbGuesses -= -1;
                map.put(guess, true);
                return String.valueOf(guessEvaluation.RIGHT_LETTER);
            }
        }
        return String.valueOf(guessEvaluation.INVALID_CHARACTER);
    }
        //Check if all letters have been guessed
//        if (!map.containsValue(false)) {
//            gameIsWon();
//        }
//
//    static void resetGame(){
//        String choice = "";
//        while (!choice.equals("y") && !choice.equals("n")) {
//            System.out.println(Content.askForNewGame);
//            choice = scanner.nextLine().toLowerCase();
//        }
//        if (choice.equals("y")) {
//            setupNewGame();
//            play();
//        } else {
//            System.out.println(Content.bye);
//        }
//    }
//
//    static void setupNewGame() {
//        System.out.println(Content.startGame);
//        gameWon = false;
//        Game.setDifficulty();
//        Word.secretWord = "";
//        Word.guessedLettersMap.clear();
//        Word.generate();
//        System.out.printf(Content.showWordLength, Word.secretWord.length());
//    }
//
//    // Gameplay
//    static void play() {
//        while (numbGuesses > 0) {
//            System.out.printf(Content.showGuessesLeft, numbGuesses);
//            Word.printGuessedLetters(Word.secretWord);
//
//            System.out.print(Content.askForGuess);
//            String guess = scanner.nextLine().toLowerCase();
//
//            evaluateGuess(guess);
//        }
//
//        if (!gameWon) {
//            System.out.println(Content.showOutOfGuesses);
//            System.out.println(Content.showSecretWord);
//            Word.printSecretWord();
//        }
//
//        System.out.println(Content.gameOver);
//        resetGame();
//    }
}
