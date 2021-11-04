package se.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBoardTest {

    @Test
    void callingGetNextGenerationWithNoAliveCellsReturnsNoAliveCells(){
        GameBoard gameBoard = new GameBoard();
        List<Cell> list= new ArrayList<>();
        assertThat(gameBoard.getNextGeneration(list)).isEqualTo(list);
    }

    @Test
    void callingGetNextGenerationWithOneAliveCellReturnsNoAliveCells(){

        GameBoard gameBoard = new GameBoard();
        List<Cell> inBoundList = new ArrayList<>(List.of(new Cell(0,0)));
        List<Cell> expectedList = new ArrayList<>();

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }

    @Test
    void callingGetNextGenerationWithTwoAliveCellReturnsNoAliveCells(){

        GameBoard gameBoard = new GameBoard();
        List<Cell> inBoundList = new ArrayList<>(List.of(new Cell(0,0), new Cell(1,0)));
        List<Cell> expectedList = new ArrayList<>();

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }

    @Test
    void callingGetNextGenerationWithThreeAliveCellsInARowReturnsMiddleCellAlive(){

        GameBoard gameBoard = new GameBoard();
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,1);
        Cell cell3 = new Cell(0,2);
        List<Cell> inBoundList = new ArrayList<>(List.of(cell1, cell2, cell3));
        List<Cell> expectedList = new ArrayList<>(List.of(cell2));

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }
    @Test
    void callingGetNextGenerationWithThreeAliveCellsSeparatedReturnsNoALiveCells(){

        GameBoard gameBoard = new GameBoard();
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,3);
        Cell cell3 = new Cell(1,0);
        List<Cell> inBoundList = new ArrayList<>(List.of(cell1, cell2, cell3));
        List<Cell> expectedList = new ArrayList<>();

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }

    @Test
    void callingGetNextGenerationWithThreeAliveCellsOnTwoRowsReturnsOneAliveCell(){

        GameBoard gameBoard = new GameBoard();
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,2);
        Cell cell3 = new Cell(1,1);
        List<Cell> inBoundList = new ArrayList<>(List.of(cell1, cell2, cell3));
        List<Cell> expectedList = new ArrayList<>(List.of(cell3));

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }

}
