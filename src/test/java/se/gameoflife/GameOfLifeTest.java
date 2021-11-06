package se.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameOfLifeTest {

    GameOfLife gameOfLife;

    @Mock
    FileReader mockedFileReader;

    @BeforeEach
    public void setUp(){
        gameOfLife = new GameOfLife(mockedFileReader);
    }

    @Test
    void callingStartGameCallsReadFile() {
        when(mockedFileReader.readFile(Mockito.anyString())).thenReturn(Mockito.any());
        gameOfLife.startGame();
        verify(mockedFileReader).readFile(Mockito.anyString());
    }


}
