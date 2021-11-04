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

}
