package se.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
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


}
