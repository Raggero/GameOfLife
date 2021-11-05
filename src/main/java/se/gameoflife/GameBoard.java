package se.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    public List<Cell> getNextGeneration(List<Cell> list) {
        if (list.size() < 3) {
            list.clear();
            return list;
        }
        List<Cell> nextGeneration = new ArrayList<>();
        int neighbours;
        for (int i = 0; i < list.size(); i++) {

            neighbours = 0;

            for (int j = 0; j < list.size(); j++) {

                if(list.get(j).row == list.get(i).row - 1){
                    if(list.get(j).column == list.get(i).column - 1 ){
                        neighbours++;
                    }
                    if(list.get(j).column == list.get(i).column){
                        neighbours++;
                    }
                    if(list.get(j).column == list.get(i).column +1 ){
                        neighbours++;
                    }
                }

                if(list.get(j).row == list.get(i).row){
                    if (list.get(j).column == list.get(i).column -1){
                        neighbours++;
                    }
                    if(list.get(j).column == list.get(i).column +1){
                        neighbours++;
                    }
                }

                if(list.get(j).row == list.get(i).row +1){
                    if(list.get(j).column == list.get(i).column -1){
                        neighbours++;
                    }
                    if(list.get(j).column == list.get(i).column){
                        neighbours++;
                    }
                    if(list.get(i).column == list.get(i).column -1){
                        neighbours++;
                    }
                }
            }

            if (neighbours == 2 || neighbours == 3) {
                nextGeneration.add(list.get(i));
            }
        }
        return nextGeneration;
    }

}
