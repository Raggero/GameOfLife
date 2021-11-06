package se.gameoflife;

import java.util.Arrays;
import java.util.List;

public class GameLoader {

    int[] dimensions;

    private void loadDimensions(List<String> stringList) {
        String[] stringDimensions = stringList.get(0).split(",");
        dimensions = Arrays.stream(stringDimensions)
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    public Board loadGame(List<String> stringList) {
        loadDimensions(stringList);
        Board board = new Board();
        if(stringList.size() > 1){
            for (int i = 0; i < dimensions[0]; i++) {
                String[] cell = stringList.get(i + 1).trim().split(" ");
                for (int j = 0; j < dimensions[1]; j++) {
                    if(cell[j].equals("x")){
                        board.add(new Cell(i,j));
                    }
                }
            }
        }
        return board;
    }
}
