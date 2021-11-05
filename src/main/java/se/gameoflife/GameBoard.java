package se.gameoflife;

public class GameBoard {

    int boardRows;
    int boardColumns;

    Board nextGeneration;

    public GameBoard(int boardRows, int boardColumns) {
        this.boardRows = boardRows;
        this.boardColumns = boardColumns;
    }

    public Board getNextGeneration(Board cellBoard) {
        nextGeneration = new Board();
        int neighbours;
        for (int row = 0; row < boardRows; row++) {
            for (int column = 0; column < boardColumns; column++) {
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
