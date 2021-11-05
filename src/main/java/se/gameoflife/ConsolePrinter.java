package se.gameoflife;

public class ConsolePrinter {

    public void print(Board board) {
        if(!board.getCellList().isEmpty()){
            System.out.println("x");
        }else{
            System.out.println(".");
        }


    }
}
