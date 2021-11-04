package se.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {


    public List<Cell> getNextGeneration(List<Cell> list) {
        if (list.size() < 3) {
            list.clear();
            return list;
        }
        List<Cell> nextGeneration = new ArrayList<>();
        int neighbours;
        for (int i = 0; i < list.size(); i++) {
            neighbours = countNeighbours(list, i);
            createNextGeneration(nextGeneration, neighbours, list.get(i));
        }
        return nextGeneration;
    }

    private void createNextGeneration(List<Cell> nextGeneration, int neighbours, Cell cell) {
        if (neighbours == 2 || neighbours == 3) {
            nextGeneration.add(cell);
        }
    }

    private int countNeighbours(List<Cell> list, int i) {
        int neighbours = 0;
        for (int j = 0; j < list.size(); j++) {
            neighbours = getNeighbours(neighbours, list.get(i).column, list.get(j).column);
        }
        return neighbours;
    }

    private int getNeighbours(int neighbours, int cellToCheckColumn, int potentialNeigbourColumn) {
        if (potentialNeigbourColumn == cellToCheckColumn - 1 || potentialNeigbourColumn == cellToCheckColumn + 1) {
            neighbours++;
        }
        return neighbours;
    }


}
