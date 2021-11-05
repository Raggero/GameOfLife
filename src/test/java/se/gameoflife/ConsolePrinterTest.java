package se.gameoflife;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
    void callingPrintPrintsABoardOf1x1WithDotForDead(){
        ConsolePrinter consolePrinter = new ConsolePrinter();
        Board board = new Board(new ArrayList<>());
        consolePrinter.print(board);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(".");
    }
}
