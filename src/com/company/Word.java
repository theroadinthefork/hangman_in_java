package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Word {

    static String generate() {
        String line = "";
        try {
                // Check words.txt file length
                Path path = Paths.get("words.txt");
                long totalLines = Files.lines(path).count();

                // Get random word where at the character count is at least 3

                while (line.length() < 3) {
                    Random random = new Random();
                    int lineNumber = random.nextInt((int)totalLines);

                    Stream<String> lines = Files.lines(path);
                    line = lines.skip(lineNumber).findFirst().get();
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
}
