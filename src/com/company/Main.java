package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Game start
        System.out.println(Content.startGame);

        Game.setDifficulty();

        // Generate random word
        System.out.println(Word.generate());

    }
}
