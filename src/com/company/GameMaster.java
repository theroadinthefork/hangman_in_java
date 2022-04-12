package com.company;

import java.util.*;

public class GameMaster {
    String name, secretWord;
    int allowedGuesses;
    HashMap<String, Boolean> guessedLettersMap;
    Game game;
    Scanner scanner = new Scanner(System.in);

    GameMaster (String letter) {
        name = setName(letter);
        allowedGuesses = setAllowedGuesses(letter);
        secretWord = Word.generate();
        guessedLettersMap = Word.mapGuessedLetters(secretWord);
        introduce();
        game = new Game(allowedGuesses);
        hostGame();
    }

    void introduce () {
        System.out.printf(Content.introduceGameMaster, name, allowedGuesses);
        System.out.printf(Content.showWordLength, secretWord.length());
    }

    void hostGame() {
        do {
            // Show remaining guesses if game hasn't been won
            if (!game.getCurrentState().equals("WON")) {
                System.out.printf(Content.showGuessesLeft, game.getNumbGuesses());
            }

            Word.printGuessedLetters(this.secretWord, this.guessedLettersMap);

            System.out.println(Content.askForGuess);
            String guess = scanner.nextLine().toLowerCase();

            // Evaluate guess
            game.setGuessState(game.evaluateGuess(guess, this.secretWord, this.guessedLettersMap));
            giveHint(game.getGuessState(), guess);

            // Update game state
            game.evaluateState(game.getGuessState());

        } while (game.getCurrentState().equals("INPLAY"));

        // Show user has lost
        if (game.getCurrentState().equals("LOST")) {
            System.out.println(Content.showOutOfGuesses);
            System.out.println(Content.showSecretWord);
        }
        Word.printSecretWord(this.secretWord);

        System.out.println(Content.gameOver);

        // Ask if user wants a new game
        String input;
        do {
            System.out.println(Content.askForNewGame);
            input = scanner.nextLine().toLowerCase();
        } while (input.matches("[yn]"));

        if (input.equals("y")) {
            startNewGame();
        } else {
            System.out.println(Content.bye);
        }

    }

    static void startNewGame () {

    }

    void giveHint(Game.guessEvaluation g, String guess) {
        switch (g) {
            case WRONG_LETTER:
                System.out.printf(Content.wrongLetter, guess);
                break;
            case RIGHT_LETTER:
                System.out.printf(Content.rightLetter, guess);
                break;
            case WRONG_WORD:
                System.out.println(Content.wrongWord);
                break;
            case RIGHT_WORD:
                System.out.println(Content.rightWord);
                break;
            case INVALID_CHARACTER:
                System.out.println(Content.invalidCharacter);
                break;
            case GUESSED_LETTER:
                System.out.println(Content.guessedLetter);
                break;
        }
    }

    String setName (String letter) {
        HashMap<String, String> difficultyMap = new HashMap<>();
        difficultyMap.put("e", "Easton");
        difficultyMap.put("n", "Norman");
        difficultyMap.put("h", "Hardy");
        difficultyMap.put("i", "Impi");

        return difficultyMap.get(letter);
    }

    int setAllowedGuesses (String letter) {
        HashMap<String, Integer> numbGuessesMap = new HashMap<>();
        numbGuessesMap.put("e", 18);
        numbGuessesMap.put("n", 14);
        numbGuessesMap.put("h", 10);
        numbGuessesMap.put("i", 3);

        return numbGuessesMap.get(letter);
    }
}
