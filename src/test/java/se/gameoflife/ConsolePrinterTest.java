package se.gameoflife;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsolePrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void callingPrintPrintsDotForDead(){
        int[] dimensions = {1,0};
        ConsolePrinter consolePrinter = new ConsolePrinter(dimensions);
        Board board = new Board(new ArrayList<>());
        consolePrinter.print(board);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(".");
    }

    @Test
    void callingPrintPrintsXForAlive(){
        int[] dimensions = {1,0};
        ConsolePrinter consolePrinter = new ConsolePrinter(dimensions);
        Board board = new Board(new ArrayList<>(List.of(new Cell(0,0))));
        consolePrinter.print(board);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("x");
    }

    @Test
    void callingPrintPrintsThreeDeadCellsByPeriodAndSpaceBetween(){
        int[] dimensions = {1,3};
        ConsolePrinter consolePrinter = new ConsolePrinter(dimensions);
        System.setOut(new PrintStream(outputStreamCaptor));

        Board board = new Board(new ArrayList<>());

        String expectedOutput = ". . .";
        consolePrinter.print(board);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }


}
