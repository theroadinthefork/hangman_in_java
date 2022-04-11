package com.company;

import java.util.*;

//public class Game {
//    static int numbGuesses;
//    static Boolean gameWon;
//    static Scanner scanner = new Scanner(System.in);


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
//
//    static void gameIsWon() {
//        System.out.println(Content.endGame);
////        Word.printSecretWord();
//        numbGuesses = 0;
//        gameWon = true;
//    }
//
//    static void evaluateGuess(String guess) {
//        //Check if they guessed the word
//        if (guess.length() > 1) {
//            if (guess.equals(Word.secretWord)) {
//                gameIsWon();
//                return;
//            } else {
//                System.out.println(Content.wrongWord);
//                numbGuesses -= 1;
//            }
//        }
//
//        // Check if valid character
//        if (guess.matches("[a-zA-Z]")) {
//
//            //Check if they guessed a letter
//            if (Word.guessedLettersMap.get(guess) == null) {
//                numbGuesses -= 1;
//                System.out.printf(Content.showWrongGuess, guess);
//            } else if (Word.guessedLettersMap.get(guess)) {
//                System.out.printf(Content.showAlreadyGuessed, guess);
//            } else {
//                System.out.printf(Content.showCorrectGuess, guess);
//                Word.guessedLettersMap.put(guess, true);
//                numbGuesses -= 1;
//            }
//        } else if (guess.length() == 1){
//            System.out.println(Content.invalidCharacter);
//        }
//
//        //Check if all letters have been guessed
//        if (!Word.guessedLettersMap.containsValue(false)) {
//            gameIsWon();
//        }
//    }
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
//}
