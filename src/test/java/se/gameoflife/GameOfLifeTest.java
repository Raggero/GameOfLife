package se.gameoflife;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameOfLifeTest {

    @Mock
    FileReader mockedFileReader;

    @Test
    void callingstartGameCallsLoadGame() {
        GameOfLife gameOfLife = new GameOfLife(mockedFileReader);
        when(mockedFileReader.readFile(Mockito.anyString())).thenReturn(Mockito.any());
        gameOfLife.startGame();
        verify(mockedFileReader).readFile(Mockito.anyString());
    }


}
