package com.company;

public class Main {
    public static void main(String[] args) {

        // Game start
        System.out.println(Content.startGame);
        Game.setDifficulty();

        // Generate random word
        Word.generate();
        System.out.println(Word.secretWord);
        System.out.printf(Content.showWordLength, Word.secretWord.length());

        // Start gameplay
        Game.play();


    }
}
