package se.gameoflife.game;

import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameLoader {

    private int[] dimensions;

    public Board loadGame(List<String> stringList) {
        loadDimensions(stringList);
        List<Cell> cellList = loadBoard(stringList);
        return new Board(cellList);
    }

    private void loadDimensions(List<String> stringList) {
        dimensions = Arrays.stream(splitList(stringList, 0, ","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private List<Cell> loadBoard(List<String> stringList) {
        List<Cell> cellList = new ArrayList<>();
        if (stringList.size() > 1) {
            for (int i = 0; i < dimensions[0]; i++) {
                String[] cell = splitList(stringList, i + 1, " ");
                for (int j = 0; j < dimensions[1]; j++) {
                    if (cell[j].equals("x")) {
                        cellList.add(new Cell(i, j));
                    }
                }
            }
        }
        return cellList;
    }

    private String[] splitList(List<String> stringList, int index, String s) {
        return stringList.get(index).trim().split(s);
    }

    public int[] getDimensions() {
        return dimensions;
    }
}
