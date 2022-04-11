package com.company;

import java.util.*;

public class GameMaster {
    String name, secretWord;
    int allowedGuesses;
    HashMap<String, Boolean> guessedLettersMap;
    Game game;

    GameMaster (String letter) {
        name = setName(letter);
        allowedGuesses = setAllowedGuesses(letter);
        secretWord = Word.generate();
        guessedLettersMap = Word.mapGuessedLetters(secretWord);
        introduce();
        game = new Game(allowedGuesses);
        startGame();
    }

    void introduce () {
        System.out.printf(Content.introduceGameMaster, name, allowedGuesses);
        System.out.printf(Content.showWordLength, secretWord.length());
    }

    void startGame() {
        Scanner scanner = new Scanner(System.in);
        String guess;

        do {
            Word.printGuessedLetters(this.secretWord, this.guessedLettersMap);

            System.out.println(Content.askForGuess);
            guess = scanner.nextLine().toLowerCase();

            // Evaluate guess
            game.guessState = game.evaluateGuess(guess, this.secretWord, this.guessedLettersMap);
            giveHint(game.guessState, guess);

            // Update game state
            game.evaluateState(game.guessState);

            System.out.printf(Content.showGuessesLeft, game.numbGuesses);
        } while (game.currentState.equals("INPLAY"));


        if (game.currentState.equals("LOST")) {
            System.out.println(Content.showOutOfGuesses);
            System.out.println(Content.showSecretWord);
        }
        Word.printSecretWord(this.secretWord);

        System.out.println(Content.gameOver);
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
        numbGuessesMap.put("e", 12);
        numbGuessesMap.put("n", 10);
        numbGuessesMap.put("h", 8);
        numbGuessesMap.put("i", 1);

        return numbGuessesMap.get(letter);
    }
}
