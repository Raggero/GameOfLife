package se.gameoflife;

import java.util.List;

public class GameOfLife {

    private static final String file = "src/main/resources/gameoflife.txt";

    private final FileReader fileReader;
    private final GameLoader gameLoader;
    private final ConsolePrinter consolePrinter;

    public GameOfLife(FileReader fileReader, GameLoader gameLoader, ConsolePrinter consolePrinter) {
        this.fileReader = fileReader;
        this.gameLoader = gameLoader;
        this.consolePrinter = consolePrinter;
    }

    public void startGame() {
        List<String> fileList = fileReader.readFile(file);
        Board board = gameLoader.loadGame(fileList);
        consolePrinter.print(board, gameLoader.getDimensions());
    }
}
