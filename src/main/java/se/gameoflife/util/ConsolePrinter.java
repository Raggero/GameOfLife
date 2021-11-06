package se.gameoflife.util;

import se.gameoflife.model.Board;

public class ConsolePrinter {

    public void print(Board board, int[] dimensions) {
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                System.out.print(printCell(board, i, j));
            }
            System.out.println();
        }
    }

    private String printCell(Board board, int i, int j) {
        return (board.getCell(i, j)) == 1 ? "x " : ". ";
    }
}
