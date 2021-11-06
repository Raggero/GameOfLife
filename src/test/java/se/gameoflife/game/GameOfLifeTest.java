package se.gameoflife.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.gameoflife.model.Board;
import se.gameoflife.util.ConsolePrinter;
import se.gameoflife.util.FileReader;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameOfLifeTest {

    GameOfLife gameOfLife;

    @Mock
    FileReader mockedFileReader;

    @Mock
    GameLoader mockedGameLoader;

    @Mock
    ConsolePrinter mockedConsolePrinter;

    @Mock
    GameBoard mockedGameBoard;

    @Captor
    ArgumentCaptor<String> stringCaptor;

    @Captor
    ArgumentCaptor<ArrayList<String>> listArgumentCaptor;

    @Captor
    ArgumentCaptor<Board> boardCaptor;

    @Captor
    ArgumentCaptor<Object> arrayCaptor;

    @BeforeEach
    public void setUp() {
        gameOfLife = new GameOfLife(mockedFileReader, mockedGameLoader, mockedConsolePrinter, mockedGameBoard);
    }

    @Test
    void callingStartGameCallsReadFile() {
        when(mockedFileReader.readFile(Mockito.anyString())).thenReturn(Mockito.any());
        gameOfLife.startGame();

        verify(mockedFileReader).readFile(Mockito.anyString());
    }

    @Test
    void callingStartGameCallsReadFileWithCorrectArgument() {
        String path = "src/main/resources/gameoflife.txt";
        when(mockedFileReader.readFile(path)).thenReturn(Mockito.any());
        gameOfLife.startGame();

        verify(mockedFileReader).readFile(stringCaptor.capture());
        String capturedArgument = stringCaptor.getValue();
        assertThat(capturedArgument).isEqualTo(path);
    }

    @Test
    void callingStartGameCallsLoadGame() {
        when(mockedGameLoader.loadGame(Mockito.anyList())).thenReturn(Mockito.any());
        gameOfLife.startGame();

        verify(mockedFileReader).readFile(Mockito.anyString());
    }

    @Test
    void callingStartGameCallsLoadGameWithCorrectArgument() {
        List<String> strings = new ArrayList<>(List.of("1,3", "x . x"));
        when(mockedFileReader.readFile(Mockito.anyString())).thenReturn(strings);
        when(mockedGameLoader.loadGame(strings)).thenReturn(Mockito.any());
        gameOfLife.startGame();

        verify(mockedGameLoader).loadGame(listArgumentCaptor.capture());
        List<String> capturedArgument = listArgumentCaptor.getValue();
        assertThat(capturedArgument).isEqualTo(strings);
    }

    @Test
    void callingStartGameCallsPrint() {
        doNothing().when(mockedConsolePrinter).print(Mockito.any(), Mockito.any());
        gameOfLife.startGame();

        verify(mockedConsolePrinter, atLeastOnce()).print(Mockito.any(), Mockito.any());
    }

    @Test
    void callingStartGameCallsPrintWithCorrectArguments() {
        List<String> strings = new ArrayList<>(List.of("1,3", "x . x"));
        Board board = new Board();
        int[] dimensions = {3, 3};
        when(mockedFileReader.readFile(Mockito.anyString())).thenReturn(strings);
        when(mockedGameLoader.loadGame(strings)).thenReturn(board);
        when(mockedGameLoader.getDimensions()).thenReturn(dimensions);
        when(mockedGameBoard.getNextGeneration(Mockito.any(), Mockito.any())).thenReturn(board);
        doNothing().when(mockedConsolePrinter).print(Mockito.any(), Mockito.any());
        gameOfLife.startGame();

        verify(mockedConsolePrinter, atLeastOnce()).print(boardCaptor.capture(), (int[]) arrayCaptor.capture());
        Board capturedArgument = boardCaptor.getValue();
        int[] secondCapturedArgument = (int[]) arrayCaptor.getValue();
        assertThat(capturedArgument).isEqualTo(board);
        assertThat(secondCapturedArgument).isEqualTo(dimensions);
    }

    @Test
    void callingStartGameCallsGetNextGeneration() {
        when(mockedGameBoard.getNextGeneration(Mockito.any(), Mockito.any())).thenReturn(Mockito.any());
        gameOfLife.startGame();

        verify(mockedGameBoard, atLeastOnce()).getNextGeneration(Mockito.any(), Mockito.any());
    }

    @Test
    void callingStartGameCallsGetNextGenerationWithCorrectArguments() {
        String path = "src/main/resources/gameoflife.txt";
        List<String> strings = new ArrayList<>(List.of("1,3", "x . x"));
        Board board = new Board();
        Board board2 = new Board();
        int[] dimensions = {3, 3};
        when(mockedFileReader.readFile(path)).thenReturn(strings);
        when(mockedGameLoader.loadGame(strings)).thenReturn(board);
        when(mockedGameLoader.getDimensions()).thenReturn(dimensions);
        doNothing().when(mockedConsolePrinter).print(Mockito.any(), Mockito.any());
        when(mockedGameBoard.getNextGeneration(board, dimensions)).thenReturn(board2);
        gameOfLife.startGame();

        verify(mockedGameBoard, atLeastOnce()).getNextGeneration(boardCaptor.capture(), (int[]) arrayCaptor.capture());
        Board capturedArgument = boardCaptor.getValue();
        int[] secondCapturedArgument = (int[]) arrayCaptor.getValue();
        assertThat(capturedArgument).isEqualTo(board);
        assertThat(secondCapturedArgument).isEqualTo(dimensions);
    }


}
