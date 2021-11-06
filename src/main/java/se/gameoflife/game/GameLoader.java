package se.gameoflife.game;

import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;

import java.util.Arrays;
import java.util.List;

public class GameLoader {

    private int[] dimensions;

    public Board loadGame(List<String> stringList) {
        loadDimensions(stringList);
        Board board = new Board();
        if (stringList.size() > 1) {
            loadBoard(stringList, board);
        }
        return board;
    }

    private void loadBoard(List<String> stringList, Board board) {
        for (int i = 0; i < dimensions[0]; i++) {
            String[] cell = stringList.get(i + 1).trim().split(" ");
            for (int j = 0; j < dimensions[1]; j++) {
                if (cell[j].equals("x")) {
                    board.addCell(new Cell(i, j));
                }
            }
        }
    }

    private void loadDimensions(List<String> stringList) {
        String[] stringDimensions = stringList.get(0).split(",");
        dimensions = Arrays.stream(stringDimensions)
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    public int[] getDimensions() {
        return dimensions;
    }
}
