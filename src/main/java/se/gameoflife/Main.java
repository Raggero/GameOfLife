package se.gameoflife;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(
                new FileReader(), new GameLoader(), new ConsolePrinter(), new GameBoard());

        gameOfLife.startGame();
    }
}
