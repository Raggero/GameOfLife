package se.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBoardTest {

    @Test
    void callingGetNextGenerationWithNoAliveCellsReturnsNoAliveCells() {
        GameBoard gameBoard = new GameBoard(3, 3);

        Board inputBoard = new Board(new ArrayList<>());

        Board expectedBoard = new Board(new ArrayList<>());
        assertThat(gameBoard.getNextGeneration(inputBoard)).isEqualTo(expectedBoard);
    }

    @Test
    void callingGetNextGenerationWithOneAliveCellReturnsNoAliveCells() {

        GameBoard gameBoard = new GameBoard(3, 3);

        Board inputBoard = new Board(new ArrayList<>(List.of(new Cell(0, 0))));

        Board expectedBoard = new Board(new ArrayList<>());

        assertThat(gameBoard.getNextGeneration(inputBoard)).isEqualTo(expectedBoard);
    }

  /*
    @Test
    void callingGetNextGenerationWithTwoAliveCellReturnsNoAliveCells(){

        GameBoard gameBoard = new GameBoard(3,3);
        List<Cell> inBoundList = new ArrayList<>(List.of(new Cell(0,0), new Cell(1,0)));
        List<Cell> expectedList = new ArrayList<>();

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }

    @Test
    void callingGetNextGenerationWithThreeAliveCellsDiagonallyReturnsMiddleCellAlive(){

        GameBoard gameBoard = new GameBoard(3,3);
        Cell cell1 = new Cell(0,2);
        Cell cell2 = new Cell(1,1);
        Cell cell3 = new Cell(2,0);
        List<Cell> inBoundList = new ArrayList<>(List.of(cell1, cell2, cell3));
        List<Cell> expectedList = new ArrayList<>(List.of(cell2));

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }
    @Test
    void callingGetNextGenerationWithFourAliveCellsSeparatedReturnsNoALiveCells(){

        GameBoard gameBoard = new GameBoard(3,3);
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,2);
        Cell cell3 = new Cell(2,0);
        Cell cell4 = new Cell(2,2);
        List<Cell> inBoundList = new ArrayList<>(List.of(cell1, cell2, cell3, cell4));
        List<Cell> expectedList = new ArrayList<>();

        assertThat(gameBoard.getNextGeneration(inBoundList)).isEqualTo(expectedList);
    }

    @Test
    void callingGetNextGenerationWithThreeAliveCellsMakesOneCellComeAlive() {

        GameBoard gameBoard = new GameBoard(3, 3);
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 2);
        Cell cell3 = new Cell(1, 1);
        Cell cell4 = new Cell(0, 1);
        List<Cell> inBoundList = new ArrayList<>(List.of(cell1, cell2, cell3));
        List<Cell> expectedList = new ArrayList<>(List.of(cell3, cell4));

        assertThat(gameBoard.getNextGeneration(inBoundList)).hasSameElementsAs(expectedList);
    }*/

}
