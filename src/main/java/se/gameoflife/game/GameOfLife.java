package se.gameoflife.game;

import se.gameoflife.model.Board;
import se.gameoflife.util.ConsolePrinter;
import se.gameoflife.util.FileReader;

import java.util.List;

public record GameOfLife(FileReader fileReader, GameLoader gameLoader,
                         ConsolePrinter consolePrinter, GameBoard gameBoard) {

    private static final String file = "src/main/resources/gameoflife.txt";

    public void startGame() {
        List<String> fileList = fileReader.readFile(file);
        Board board = gameLoader.loadGame(fileList);
        int[] dimensions = gameLoader.getDimensions();
        playGameOfLife(board, dimensions);
    }

    private void playGameOfLife(Board board, int[] dimensions) {
        for (int i = 0; i < 5; i++) {
            consolePrinter.print(board, dimensions);
            board = gameBoard.getNextGeneration(board, dimensions);
        }
    }
}
