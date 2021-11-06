package se.gameoflife.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {


    @Test
    void callingGetListReturnList(){
        Cell cell = new Cell(1, 1);
        Board board = new Board(new ArrayList<>(List.of(cell)));
        assertThat(board.getCellList()).contains(cell);
    }

    @Test
    void callingAddWithACellAddsCellToList() {
        Cell cell = new Cell(1, 1);
        Board board = new Board();
        board.add(cell);
        assertThat(board.getCellList()).contains(cell);
    }

    @Test
    void callingGetCellWithCorrectCoordinatesReturnsCell() {
        Cell cell = new Cell(1, 1);
        Board board = new Board(new ArrayList<>(List.of(cell)));
        assertThat(board.getCell(1, 1)).isEqualTo(cell);
    }

    @Test
    void callingGetCellWithWrongCoordinatesReturnsNull() {
        Cell cell = new Cell(1, 1);
        Board board = new Board(new ArrayList<>(List.of(cell)));
        assertThat(board.getCell(2, 2)).isNull();
    }

    @Test
    void callingCountCellWithCorrectCoordinatesReturnsOne() {
        Cell cell = new Cell(1, 1);
        Board board = new Board(new ArrayList<>(List.of(cell)));
        assertThat(board.countCell(1, 1)).isEqualTo(1);
    }

    @Test
    void callingCountCellWithWrongCoordinatesReturnsZero() {
        Cell cell = new Cell(1, 1);
        Board board = new Board(new ArrayList<>(List.of(cell)));
        assertThat(board.countCell(2, 2)).isZero();
    }

    @Test
    void callingEqualsWithTwoBoardContainingSameListReturnsTrue() {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(1, 1);
        Board board1 = new Board(new ArrayList<>(List.of(cell1, cell2)));
        Board board2 = new Board(new ArrayList<>(List.of(cell1, cell2)));

        assertEquals(board1, board2);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.simple().forClass(Board.class).verify();
    }

    @Test
    void callingHashcodeOnTwoBoardsContainingSameCellReturnsTrue() {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(1, 1);
        Board board1 = new Board(new ArrayList<>(List.of(cell1, cell2)));
        Board board2 = new Board(new ArrayList<>(List.of(cell1, cell2)));
        assertEquals(board1.hashCode(), board2.hashCode());
    }


}
