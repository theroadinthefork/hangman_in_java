package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String gameMasterChoice;

        do {
            System.out.println(Content.chooseGameMaster);
            gameMasterChoice = scanner.nextLine().toLowerCase();
        } while (!gameMasterChoice.matches("[enhi]"));

        GameMaster gameMaster = new GameMaster(gameMasterChoice);

        System.out.println(gameMaster.name + gameMaster.allowedGuesses);

        Game.setupNewGame();
        Game.play();

    }
}
