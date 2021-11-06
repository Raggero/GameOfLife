package se.gameoflife.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameLoaderTest {

    GameLoader gameLoader;

    @BeforeEach
    public void setUp() {
        gameLoader = new GameLoader();
    }

    @Test
    void callingLoadDimensionsReturnsDimensionsToOneOne() {
        List<String> strings = new ArrayList<>(List.of("1,1"));
        int[] expected = {1,1};

        gameLoader.loadGame(strings);

        assertThat(gameLoader.getDimensions()).isEqualTo(expected);
    }

    @Test
    void callingLoadDimensionsReturnsDimensionsToThreeThree() {
        List<String> strings = new ArrayList<>(List.of("3,3"));
        int[] expected = {3,3 };

        gameLoader.loadGame(strings);

        assertThat(gameLoader.getDimensions()).isEqualTo(expected);
    }

    @Test
    void callingLoadBoardWithNoAliveCellsReturnsBoardWithEmptyList() {
        List<String> strings = new ArrayList<>(List.of("1,1", "."));

        Board expected = new Board();

        assertThat(gameLoader.loadGame(strings)).isEqualTo(expected);
    }

    @Test
    void callingLoadBoardWithOneAliveCellsReturnsBoardWithOneCellInList() {
        List<String> strings = new ArrayList<>(List.of("1,1", "x"));

        Board expected = new Board(new ArrayList<>(List.of(new Cell(0,0))));

        assertThat(gameLoader.loadGame(strings)).isEqualTo(expected);
    }

    @Test
    void callingLoadBoardWithTwoAliveCellsWithOneDeadInBetweenReturnsBoardWithTwoCellInList() {
        List<String> strings = new ArrayList<>(List.of("1,3", "x . x"));

        Board expected = new Board(new ArrayList<>(List.of(new Cell(0,0), new Cell(0,2))));

        assertThat(gameLoader.loadGame(strings)).isEqualTo(expected);
    }

    @Test
    void callingLoadBoardWithMixedCellsReturnsExpectedBoard() {
        List<String> strings = new ArrayList<>(List.of("3,3", "x x .", ". . x","x . x"));
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,1);
        Cell cell3 = new Cell(1,2);
        Cell cell4 = new Cell(2,0);
        Cell cell5 = new Cell(2,2);

        Board expected = new Board(new ArrayList<>(List.of(cell1, cell2, cell3, cell4, cell5)));

        assertThat(gameLoader.loadGame(strings)).isEqualTo(expected);
    }
}
