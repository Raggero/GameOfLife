package se.gameoflife;

import java.util.List;

public class GameBoard {


    public List<Cell> getNextGeneration(List<Cell> list) {
        if (list.size() < 3) {
            list.clear();
            return list;
        }
        return list;
    }
}
