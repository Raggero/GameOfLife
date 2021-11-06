package se.gameoflife;

import java.util.List;

public class GameOfLife {

    private static final String file = "src/main/resources/gameoflife.txt";

    private final FileReader fileReader;
    private final GameLoader gameLoader;

    public GameOfLife(FileReader fileReader, GameLoader gameLoader) {
        this.fileReader = fileReader;
        this.gameLoader = gameLoader;
    }

    public void startGame() {
        List<String> fileList = fileReader.readFile(file);
        gameLoader.loadGame(fileList);
    }
}
