package se.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameOfLifeTest {

    GameOfLife gameOfLife;

    @Mock
    FileReader mockedFileReader;

    @Mock
    GameLoader mockedGameLoader;

    @Captor
    ArgumentCaptor<String> stringCaptor;

    @Captor
    ArgumentCaptor<ArrayList<String>> listArgumentCaptor;

    @BeforeEach
    public void setUp(){
        gameOfLife = new GameOfLife(mockedFileReader, mockedGameLoader);
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


}
