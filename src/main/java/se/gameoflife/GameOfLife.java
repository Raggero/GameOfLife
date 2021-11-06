package se.gameoflife;

public class GameOfLife {

    private static final String file = "src/main/resources/gameoflife.txt";

    private final FileReader fileReader;

    public GameOfLife(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void startGame() {
        fileReader.readFile(file);
    }
}
