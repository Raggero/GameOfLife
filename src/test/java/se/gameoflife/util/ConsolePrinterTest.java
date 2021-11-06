package se.gameoflife.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.gameoflife.model.Board;
import se.gameoflife.model.Cell;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsolePrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    ConsolePrinter consolePrinter;

    @BeforeEach
    public void setUp() {
        consolePrinter = new ConsolePrinter();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void callingPrintPrintsADotForOneDeadCell() {
        int[] dimensions = {1, 1};
        Board board = new Board(new ArrayList<>());
        consolePrinter.print(board, dimensions);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(".");
    }

    @Test
    void callingPrintPrintsXForOneAliveCell() {
        int[] dimensions = {1, 1};
        Board board = new Board(new ArrayList<>(List.of(new Cell(0, 0))));
        consolePrinter.print(board, dimensions);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("x");
    }

    @Test
    void callingPrintPrintsThreeDeadCellsByPeriodAndSpaceBetween() {
        int[] dimensions = {1, 3};
        Board board = new Board(new ArrayList<>());

        String expectedOutput = ". . .";
        consolePrinter.print(board, dimensions);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }

    @Test
    void callingPrintPrintsAMixOfAliveAndDeadCellsByPeriodOrXAndSpaceBetweenAndOnThreeRows() {
        int[] dimensions = {3, 3};
        Cell cell1 = new Cell(0, 2);
        Cell cell2 = new Cell(1, 0);
        Cell cell3 = new Cell(2, 1);

        Board board = new Board(new ArrayList<>(List.of(cell1, cell2, cell3)));
        String expectedOutput = ". . x " + System.lineSeparator() +
                "x . . " + System.lineSeparator() +
                ". x .";
        consolePrinter.print(board, dimensions);

        assertThat(outputStreamCaptor.toString().trim()).hasToString(expectedOutput);
    }


}
