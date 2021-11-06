package se.gameoflife;

import se.gameoflife.game.GameBoard;
import se.gameoflife.game.GameLoader;
import se.gameoflife.game.GameOfLife;
import se.gameoflife.util.ConsolePrinter;
import se.gameoflife.util.FileReader;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(
                new FileReader(), new GameLoader(), new ConsolePrinter(), new GameBoard());

        gameOfLife.startGame();
    }
}
