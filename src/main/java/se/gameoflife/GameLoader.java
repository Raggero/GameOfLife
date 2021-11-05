package se.gameoflife;

import java.util.Arrays;
import java.util.List;

public class GameLoader {

    public int[] loadGame(List<String> stringList) {
        String[] dimensions = stringList.get(0).split(",");
        return Arrays.stream(dimensions)
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
