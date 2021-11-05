package se.gameoflife;

public class ConsolePrinter {

    int[] dimensions;

    public ConsolePrinter(int[] dimensions) {
        this.dimensions = dimensions;
    }

    public void print(Board board) {
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                printCell(board, i, j);
            }
            System.out.println();
        }
    }

    private void printCell(Board board, int i, int j) {
        if(board.countCell(i, j) == 1){
            System.out.print("x ");
        }else{
            System.out.print(". ");
        }
    }
}
