package se.gameoflife.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {

    GameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard();
    }

    @Test
    void callingGetNextGenerationWithNoAliveCellsReturnsNoAliveCells() {
        int[] dimensions = {1,1};

        Board inputBoard = new Board();
        Board expectedBoard = new Board();

        assertThat(gameBoard.getNextGeneration(inputBoard, dimensions)).isEqualTo(expectedBoard);
    }

    @Test
    void callingGetNextGenerationWithOneAliveCellReturnsNoAliveCells() {
        int[] dimensions = {1,1};

        Board inputBoard = new Board(new ArrayList<>(List.of(new Cell(0, 0))));
        Board expectedBoard = new Board();

        assertThat(gameBoard.getNextGeneration(inputBoard, dimensions)).isEqualTo(expectedBoard);
    }


    @Test
    void callingGetNextGenerationWithTwoAliveCellReturnsNoAliveCells() {
        int[] dimensions = {1,2};

        Board inputBoard = new Board(new ArrayList<>(List.of(new Cell(0, 0), new Cell(1, 0))));
        Board expectedBoard = new Board();

        assertThat(gameBoard.getNextGeneration(inputBoard, dimensions)).isEqualTo(expectedBoard);
    }

    @Test
    void callingGetNextGenerationWithThreeAliveCellsDiagonallyReturnsMiddleCellAlive() {
        int[] dimensions = {3,3};
        Cell cell1 = new Cell(0, 2);
        Cell cell2 = new Cell(1, 1);
        Cell cell3 = new Cell(2, 0);

        Board inputBoard = new Board(new ArrayList<>(List.of(cell1, cell2, cell3)));
        Board expectedBoard = new Board(new ArrayList<>(List.of(cell2)));

        assertThat(gameBoard.getNextGeneration(inputBoard, dimensions)).isEqualTo(expectedBoard);
    }


    @Test
    void callingGetNextGenerationWithFourAliveCellsSeparatedReturnsNoALiveCells() {
        int[] dimensions = {3,3};
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 2);
        Cell cell3 = new Cell(2, 0);
        Cell cell4 = new Cell(2, 2);

        Board inputBoard = new Board(new ArrayList<>(List.of(cell1, cell2, cell3, cell4)));
        Board expectedBoard = new Board();

        assertThat(gameBoard.getNextGeneration(inputBoard, dimensions)).isEqualTo(expectedBoard);
    }

    @Test
    void callingGetNextGenerationWithThreeAliveCellsMakesOneDeadCellComeAlive() {
        int[] dimensions = {3,3};
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 2);
        Cell cell3 = new Cell(0, 1);
        Cell cell4 = new Cell(1, 1);

        Board inputBoard = new Board(new ArrayList<>(List.of(cell1, cell2, cell4)));
        Board expectedBoard = new Board(new ArrayList<>(List.of(cell3, cell4)));

        assertThat(gameBoard.getNextGeneration(inputBoard, dimensions)).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedBoard);
    }

    @Test
    void callingGetNextGenerationWithAllAliveCellsOnBoardReturnsExpectedResult() {
        int[] dimensions = {3,3};
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);
        Cell cell3 = new Cell(0, 2);
        Cell cell4 = new Cell(1, 0);
        Cell cell5 = new Cell(1, 1);
        Cell cell6 = new Cell(1, 2);
        Cell cell7 = new Cell(2, 0);
        Cell cell8 = new Cell(2, 1);
        Cell cell9 = new Cell(2, 2);

        Board inBoard = new Board(new ArrayList<>(List.of(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9)));
        Board expectedBoard = new Board(new ArrayList<>(List.of(cell1, cell3, cell7, cell9)));

        assertThat(gameBoard.getNextGeneration(inBoard, dimensions)).isEqualTo(expectedBoard);
    }

    @Test
    void callingGetNextGenerationWithFiveAliveCellsReturnsExpectedResult() {
        int[] dimensions = {3,3};
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);
        Cell cell3 = new Cell(0, 2);
        Cell cell4 = new Cell(1, 0);
        Cell cell5 = new Cell(1, 1);
        Cell cell6 = new Cell(1, 2);
        Cell cell7 = new Cell(2, 0);
        Cell cell8 = new Cell(2, 1);
        Cell cell9 = new Cell(2, 2);

        Board inBoard = new Board(new ArrayList<>(List.of(cell2, cell4, cell5, cell6, cell8)));
        Board expectedBoard = new Board(new ArrayList<>(List.of(cell1, cell2, cell3, cell4, cell6, cell7, cell8, cell9)));

        assertThat(gameBoard.getNextGeneration(inBoard, dimensions)).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedBoard);
    }
}
