package se.gameoflife;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    //Ändra String -> Path

    public List<String> readFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
