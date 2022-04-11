package com.company;

import java.util.*;

public class GameMaster {
    String name, secretWord;
    int allowedGuesses;
    HashMap<String, Boolean> guessedLettersMap;

    GameMaster (String letter) {
        name = setName(letter);
        allowedGuesses = setAllowedGuesses(letter);
        secretWord = Word.generate();
        guessedLettersMap = Word.mapGuessedLetters(secretWord);
        introduce();
        Game game = new Game(allowedGuesses);
    }

    void introduce () {
        System.out.printf(Content.introduceGameMaster, name, allowedGuesses);
        System.out.printf(Content.showWordLength, secretWord.length());
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
