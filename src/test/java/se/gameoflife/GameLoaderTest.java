package se.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameLoaderTest {

    @Test
    void callingLoadDimensionsReturnsDimensionsToOneOne() {
        GameLoader gameLoader = new GameLoader();
        List<String> strings = new ArrayList<>(List.of("1,1"));
        int[] expected = {1,1};
        int[] dimensions = gameLoader.loadDimensions(strings);
        assertThat(dimensions).isEqualTo(expected);
    }

    @Test
    void callingLoadDimensionsReturnsDimensionsToThreeThree() {
        GameLoader gameLoader = new GameLoader();
        List<String> strings = new ArrayList<>(List.of("3,3"));
        int[] expected = {3,3 };
        int[] dimensions = gameLoader.loadDimensions(strings);
        assertThat(dimensions).isEqualTo(expected);
    }




}
