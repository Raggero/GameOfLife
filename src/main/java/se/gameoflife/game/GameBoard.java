package se.gameoflife.game;

import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {

    public Board getNextGeneration(Board board, int[] dimensions) {
        List<Cell> nextGeneration = getSurvivingCells(board);
        getBirths(board, dimensions, nextGeneration);
        return new Board(nextGeneration);
    }

    private List<Cell> getSurvivingCells(Board board){
        return board.getCellList().stream()
                .filter(cell -> {
                    int neighbors = getNeighbors(board, cell.getRow(), cell.getColumn());
                    return neighbors == 2 || neighbors == 3;
                })
                .collect(Collectors.toList());
    }

    private void getBirths(Board board, int[] dimensions, List<Cell> nextGen) {
        int neighbors;
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                if(board.countCell(i, j) == 0){
                    neighbors = getNeighbors(board, i, j);
                    addBirth(nextGen, neighbors, i, j);
                }
            }
        }
    }

    private void addBirth(List<Cell> nextGen, int neighbors, int i, int j) {
        if (neighbors == 3) {
            nextGen.add(new Cell(i, j));
        }
    }

    private int getNeighbors(Board board, int row, int column) {
        int neighbors = 0;
        neighbors += board.countCell(row - 1, column - 1);

        neighbors += board.countCell(row - 1, column);

        neighbors += board.countCell(row - 1, column + 1);
        neighbors += board.countCell(row, column - 1);

        neighbors += board.countCell(row, column + 1);

        neighbors += board.countCell(row + 1, column - 1);

        neighbors += board.countCell(row + 1, column);

        neighbors += board.countCell(row + 1, column + 1);
        return neighbors;
    }
}
