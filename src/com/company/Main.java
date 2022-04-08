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
        try {
            // Open words.txt file
            File words = new File("words.txt");
            Scanner wordReader = new Scanner(words);

            // Pick random line
            Random random = new Random();
            int lineNumber = random.nextInt((int)words.length());


            System.out.println(Content.test);
            System.out.println(Files.readAllLines(Paths.get("words.txt")).get(32));
            wordReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file words.txt");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Couldn't read file words.txt");
            e.printStackTrace();
        }

    }



}
