package se.gameoflife;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    @Test
    void callingEqualsWithTwoCellsWithSameParametersReturnsTrue(){
        Cell cell1 = new Cell(1,1);
        Cell cell2 = new Cell(1,1);
        assertEquals(cell1,cell2);
    }
    @Test
    void equalsContract(){
        EqualsVerifier.simple().forClass(Cell.class).verify();
    }

}
