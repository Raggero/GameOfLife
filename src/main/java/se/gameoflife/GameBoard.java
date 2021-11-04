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
            neighbours = 0;
            for (int j= 0; j < list.size(); j++) {
                int cellToCheck = list.get(i).column;
                int potentialNeigbour = list.get(j).column;
                if (potentialNeigbour == cellToCheck - 1 || potentialNeigbour == cellToCheck + 1) {
                    neighbours++;
                }
            }
            if (neighbours == 2 || neighbours == 3) {
                nextGeneration.add(list.get(i));
            }
        }
        return nextGeneration;
    }
}
