package se.gameoflife;

import java.util.List;
import java.util.Objects;

public class Board {
    
    List<Cell> cellList;

    public Board(List<Cell> cellList) {
        this.cellList = cellList;
    }


    public void add(Cell cell) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(cellList, board.cellList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellList);
    }
}
