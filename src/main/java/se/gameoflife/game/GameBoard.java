package se.gameoflife.game;

import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;

public class GameBoard {

    private Board nextGeneration;

    public Board getNextGeneration(Board cellBoard, int[] dimensions) {
        nextGeneration = new Board();
        int neighbours;
        for (int row = 0; row < dimensions[0]; row++) {
            for (int column = 0; column < dimensions[1]; column++) {
                neighbours = getNeighBours(cellBoard, row, column);
                createNextGeneration(cellBoard, neighbours, row, column);
            }
        }
        return nextGeneration;
    }

    private void createNextGeneration(Board cellBoard, int neighbours, int row, int column) {
        Cell cellToCheck = cellBoard.getCell(row, column);
        if (cellToCheck == null) {
            if (neighbours == 3) {
                nextGeneration.add(new Cell(row, column));
            }
        }else if (neighbours == 2 || neighbours == 3) {
            nextGeneration.add(cellToCheck);
        }
}

    private int getNeighBours(Board cellBoard, int row, int column) {
        int neighbours = 0;
        neighbours += cellBoard.countCell(row - 1, column - 1);

        neighbours += cellBoard.countCell(row - 1, column);

        neighbours += cellBoard.countCell(row - 1, column + 1);
        neighbours += cellBoard.countCell(row, column - 1);

        neighbours += cellBoard.countCell(row, column + 1);

        neighbours += cellBoard.countCell(row + 1, column - 1);

        neighbours += cellBoard.countCell(row + 1, column);

        neighbours += cellBoard.countCell(row + 1, column + 1);
        return neighbours;
    }

}
