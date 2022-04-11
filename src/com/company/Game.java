package com.company;

import java.util.*;

public class Game {
    int numbGuesses;
    String currentState;
    guessEvaluation guessState;
    enum guessEvaluation {WRONG_WORD, WRONG_LETTER, RIGHT_LETTER, RIGHT_WORD, INVALID_CHARACTER, GUESSED_LETTER}
//    static Scanner scanner = new Scanner(System.in);

    Game (int numbGuesses) {
        this.numbGuesses = numbGuesses;
        this.currentState = "INPLAY";
    }


    guessEvaluation evaluateGuess(String guess, String word, HashMap<String,Boolean> map) {
        //Check if they guessed the word
        if (guess.length() > 1) {
            if (guess.equals(word)) {
                return guessEvaluation.RIGHT_WORD;
            } else {
                return guessEvaluation.WRONG_WORD;
            }
        }

        // Check if valid character
        if (guess.matches("[a-zA-Z]")) {
            //Check if they guessed a letter
            if (map.get(guess) == null) {
                return guessEvaluation.WRONG_LETTER;
            } else if (map.get(guess)) {
                return guessEvaluation.GUESSED_LETTER;
            } else {
                map.put(guess, true);
                return guessEvaluation.RIGHT_LETTER;
            }
        }
        return guessEvaluation.INVALID_CHARACTER;
    }

    String evaluateState(guessEvaluation g) {
        switch (g) {
            case WRONG_LETTER:
            case RIGHT_LETTER:
            case WRONG_WORD:
                this.numbGuesses -= 1;
                break;
            case RIGHT_WORD:
                return this.currentState = "WON";
        }
        if (this.numbGuesses == 0 && this.currentState.equals("INPLAY")) {
            return this.currentState = "LOST";
        }
        return this.currentState = "INPLAY";
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
