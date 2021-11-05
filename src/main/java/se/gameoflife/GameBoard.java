package se.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    int boardRows;
    int boardColumns;

    public GameBoard(int boardRows, int boardColumns) {
        this.boardRows = boardRows;
        this.boardColumns = boardColumns;
    }

    public Board getNextGeneration(Board cellBoard) {
        if (cellBoard.cellList.size() < 3) {
            cellBoard.cellList.clear();
            return cellBoard;
        }
        Board nextGeneration = new Board();
        int neighbours;
        for (int row = 0; row < boardRows; row++) {

            neighbours = 0;

            for (int column = 0; column < boardColumns; column++) {

                Cell cellToCheck = cellBoard.getCell(row, column);

                if(cellBoard.cellList.get(column).row == cellBoard.cellList.get(row).row - 1){
                    if(cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column - 1 ){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column +1 ){
                        neighbours++;
                    }
                }

                if(cellBoard.cellList.get(column).row == cellBoard.cellList.get(row).row){
                    if (cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column -1){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column +1){
                        neighbours++;
                    }
                }

                if(cellBoard.cellList.get(column).row == cellBoard.cellList.get(row).row +1){
                    if(cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column -1){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(column).column == cellBoard.cellList.get(row).column){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(row).column ==cellBoard.cellList.get(row).column -1){
                        neighbours++;
                    }
                }
            }

            if (neighbours == 2 || neighbours == 3) {
                nextGeneration.add(cellBoard.cellList.get(row));
            }
        }
        return nextGeneration;
    }

}
