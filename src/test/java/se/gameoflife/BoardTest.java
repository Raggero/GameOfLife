package se.gameoflife;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void callingEqualsWithTwoListContainingSameListReturnsTrue(){
        Cell cell1 = new Cell(1,1);
        Cell cell2 = new Cell(1,1);
        Board board1 = new Board(new ArrayList<>(List.of(cell1, cell2)));
        Board board2 = new Board(new ArrayList<>(List.of(cell1, cell2)));

        assertEquals(board1,board2);
    }

    @Test
    void equalsContract(){
        EqualsVerifier.simple().forClass(Board.class).verify();
    }

    @Test
    void callingHashcodeOnTwoCellsWithSameParametersReturnsTrue(){
        Cell cell1 = new Cell(1,1);
        Cell cell2 = new Cell(1,1);
        Board board1 = new Board(new ArrayList<>(List.of(cell1, cell2)));
        Board board2 = new Board(new ArrayList<>(List.of(cell1, cell2)));
        assertEquals(board1.hashCode(), board2.hashCode());
    }


}
