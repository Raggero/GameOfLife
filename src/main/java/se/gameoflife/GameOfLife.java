package se.gameoflife;

import java.util.List;

public class GameOfLife {

    private static final String file = "src/main/resources/gameoflife.txt";

    private final FileReader fileReader;
    private final GameLoader gameLoader;
    private final ConsolePrinter consolePrinter;
    private final GameBoard gameBoard;

    public GameOfLife(FileReader fileReader, GameLoader gameLoader, ConsolePrinter consolePrinter, GameBoard gameBoard) {
        this.fileReader = fileReader;
        this.gameLoader = gameLoader;
        this.consolePrinter = consolePrinter;
        this.gameBoard = gameBoard;
    }

    public void startGame() {
        List<String> fileList = fileReader.readFile(file);
        Board board = gameLoader.loadGame(fileList);
        int[] dimensions = gameLoader.getDimensions();
        consolePrinter.print(board, dimensions);
        gameBoard.getNextGeneration(board, dimensions);
    }
}
