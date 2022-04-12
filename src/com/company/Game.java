package com.company;

import java.util.*;

public class Game {
    private int numbGuesses;
    private String currentState;
    private guessEvaluation guessState;
    enum guessEvaluation {WRONG_WORD, WRONG_LETTER, RIGHT_LETTER, RIGHT_WORD, INVALID_CHARACTER, GUESSED_LETTER}


    Game (int numbGuesses) {
        this.numbGuesses = numbGuesses;
        this.currentState = "INPLAY";
    }

    int getNumbGuesses() {
        return this.numbGuesses;
    }

    String getCurrentState() {
        return this.currentState;
    }

    guessEvaluation getGuessState() {
        return this.guessState;
    }

    guessEvaluation setGuessState(guessEvaluation g) {
        return this.guessState = g;
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

    static void startNewGame () {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Content.startGame);

        String gameMasterSelection;
        do {
            System.out.println(Content.chooseGameMaster);
            gameMasterSelection = scanner.nextLine().toLowerCase();
        } while (!gameMasterSelection.matches("[enhi]"));

        Main.createGameMaster(gameMasterSelection);
    }


}
