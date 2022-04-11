package com.company;

import java.util.*;

public class GameMaster {
    String name;
    int allowedGuesses;

    GameMaster (String letter) {
        this.name = setName(letter);
        this.allowedGuesses = setAllowedGuesses(letter);
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
