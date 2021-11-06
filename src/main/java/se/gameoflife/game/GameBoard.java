package se.gameoflife.game;

import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    public Board getNextGeneration(Board board, int[] dimensions) {
        List<Cell> nextGeneration = new ArrayList<>();
        getSurvivingCells(board, nextGeneration);
        getBirths(board, dimensions, nextGeneration);
        return new Board(nextGeneration);
    }
    private void getSurvivingCells(Board board, List<Cell> nextGeneration) {
        for (int i = 0; i < board.getCellList().size(); i++) {
            int neighbours = getNeighbors(board, board.getCellList().get(i).getRow(), board.getCellList().get(i).getColumn());
            addSurvivingCell(board.getCellList().get(i), neighbours, nextGeneration);
        }
    }

    private void addSurvivingCell(Cell cell, int neighbours, List<Cell> nextGeneration) {
        if (neighbours == 2 || neighbours == 3) {
            nextGeneration.add(cell);
        }
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
