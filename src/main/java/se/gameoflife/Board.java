package se.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {

    List<Cell> cellList;

    public Board(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public Board() {
        this.cellList = new ArrayList<>();
    }

    public void add(Cell cell) {
        cellList.add(cell);
    }

    public Cell getCell(int row, int column) {
        return cellList.stream()
                .filter(cell -> cell.row == row && cell.column == column)
                .findFirst()
                .orElse(null);
    }

    public int countCell(int row, int column) {
        return cellList.stream()
                .filter(cell -> cell.row == row && cell.column == column)
                .map(i -> 1)
                .findFirst()
                .orElse(0);
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
