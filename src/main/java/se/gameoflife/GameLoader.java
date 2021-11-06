package se.gameoflife;

import java.util.Arrays;
import java.util.List;

public class GameLoader {

    public int[] loadDimensions(List<String> stringList) {
        String[] dimensions = stringList.get(0).split(",");
        return Arrays.stream(dimensions)
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    public Board loadBoard(List<String> stringList) {
        Board board = new Board();
        if(stringList.get(1).equals("x")){
            board.add(new Cell(0,0));
        }
        return board;
    }
}
