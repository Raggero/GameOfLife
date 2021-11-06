package se.gameoflife;

import java.util.Arrays;
import java.util.List;

public class GameLoader {

    int[] dimensions;

    public void loadDimensions(List<String> stringList) {
        String[] stringDimenstions = stringList.get(0).split(",");
        Arrays.stream(stringDimenstions)
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    public Board loadBoard(List<String> stringList) {
        Board board = new Board();
        for (int i = 0; i < dimensions[0]; i++) {
            String[] cell = stringList.get(i + 1).trim().split(" ");
            for (int j = 0; j < dimensions[i]; j++) {
                if(cell[j].equals("x")){
                    board.add(new Cell(i,j));
                }
            }
        }
        return board;
    }
}
