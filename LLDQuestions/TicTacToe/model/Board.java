package tictactoe.model;

import tictactoe.model.PieceType;

public class Board {
    private final int size;
    private final PieceType[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new PieceType[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;
            }
        }
    }
    
    public boolean addPiece(int row, int col, PieceType pieceType) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }
        if (grid[row][col] != null) {
            return false;
        }
        grid[row][col] = pieceType;
        return true;
    }

    public boolean hasFreeCell() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        String cellEdge = "+---";
        String cellRow = "|   ";
        for (int i = 0; i < size; i++) {
            // top border of row
            for (int j = 0; j < size; j++) {
                System.out.print(cellEdge);
            }
            System.out.println("+");
            // cell contents: empty for null, else the piece
            for (int j = 0; j < size; j++) {
                String content = grid[i][j] == null ? "   " : " " + grid[i][j] + " ";
                System.out.print("|" + content);
            }
            System.out.println("|");
        }
        // bottom border
        for (int j = 0; j < size; j++) {
            System.out.print(cellEdge);
        }
        System.out.println("+");
    }
}
