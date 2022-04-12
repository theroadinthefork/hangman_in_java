package com.company;

public class Content {

    static String startGame = "*** Starting a game of HANGMAN! ***\n";
    static String chooseGameMaster = "Choose your Game Master and then hit [enter] key: [E]aston, [N]orman, [H]ardy, [I]mpi: ";
    static String introduceGameMaster = "Hi, I'm %s and I'll be your Game Master. With me, you'll get %s tries to guess the word. Let's get started!\n";

    static String showWordLength = "I've picked a word and it contains %s letters.\n\n";
    static String showGuessesLeft = "You have %s guesses remaining.\n";
    static String askForGuess = "Type a letter or word and then hit [enter] to make your guess: ";
    static String rightLetter = "\nGood guess! Letter %s is part of the word.\n";
    static String rightWord = "\nCongrats! You've guessed the word!";
    static String wrongLetter = "\nToo bad! No letter %s.\n";
    static String wrongWord = "\nNope, that's not the word.";
    static String invalidCharacter = "\nPlease only use Roman alphabetic letters.";
    static String guessedLetter = "\nSilly! You've already guessed this letter.";
    static String showOutOfGuesses = "\nSorry, you're out of guesses.";
    static String showSecretWord = "The word was:\n";
    static String gameOver = "*** GAME OVER ***\n";
    static String askForNewGame = "Would you like to start a new game? y/n: ";
    static String bye = "Thanks for playing! Bye. (Quiting app)\n";



}
