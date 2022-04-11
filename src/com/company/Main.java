package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String gameMasterSelection;

        do {
            System.out.println(Content.chooseGameMaster);
            gameMasterSelection = scanner.nextLine().toLowerCase();
        } while (!gameMasterSelection.matches("[enhi]"));

        GameMaster gameMaster = new GameMaster(gameMasterSelection);

    }

}
