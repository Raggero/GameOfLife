package se.gameoflife;

public class GameOfLife {

    private static final String file = "src/main/resources/gameoflife.txt";

    private final FileReader fileReader;
    private final GameLoader gameLoader;

    public GameOfLife(FileReader fileReader, GameLoader gameLoader) {
        this.fileReader = fileReader;
        this.gameLoader = gameLoader;
    }

    public void startGame() {

        gameLoader.loadGame(fileReader.readFile(file));
    }
}
