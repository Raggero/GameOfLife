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
        Board nextGeneration = new Board(new ArrayList<>());
        int neighbours;
        for (int i = 0; i < cellBoard.cellList.size(); i++) {

            neighbours = 0;

            for (int j = 0; j < cellBoard.cellList.size(); j++) {

                if(cellBoard.cellList.get(j).row == cellBoard.cellList.get(i).row - 1){
                    if(cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column - 1 ){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column +1 ){
                        neighbours++;
                    }
                }

                if(cellBoard.cellList.get(j).row == cellBoard.cellList.get(i).row){
                    if (cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column -1){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column +1){
                        neighbours++;
                    }
                }

                if(cellBoard.cellList.get(j).row == cellBoard.cellList.get(i).row +1){
                    if(cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column -1){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(j).column == cellBoard.cellList.get(i).column){
                        neighbours++;
                    }
                    if(cellBoard.cellList.get(i).column ==cellBoard.cellList.get(i).column -1){
                        neighbours++;
                    }
                }
            }

            if (neighbours == 2 || neighbours == 3) {
                nextGeneration.add(cellBoard.cellList.get(i));
            }
        }
        return nextGeneration;
    }

}
