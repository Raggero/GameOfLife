package se.gameoflife;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {

    String file = "src/test/resources/testfile.txt";

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
    void callingReadFileWithCorrectFileReturnsList() {
        FileReader fileReader = new FileReader();
        List<String> expectedResult = new ArrayList<>(List.of("1,1", ". . ."));

        assertThat(fileReader.readFile(file)).isEqualTo(expectedResult);
    }

    @Test
    void callingReadFileWithNoFileReturnsList() {
        FileReader fileReader = new FileReader();
        fileReader.readFile("Wrong");

        String expectedOutput = "File missing, can't start the game";

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }

}