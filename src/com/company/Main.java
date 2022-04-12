package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Game.startNewGame();
    }

    static void createGameMaster (String gameMasterSelection) {
        GameMaster gameMaster = new GameMaster(gameMasterSelection);
    }

}
