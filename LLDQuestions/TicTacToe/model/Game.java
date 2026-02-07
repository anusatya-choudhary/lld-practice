package tictactoe.model;

import tictactoe.model.Board;
import tictactoe.model.Player;
import tictactoe.model.PieceType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Scanner scanner = new Scanner(System.in);

    public Game(int boardSize, List<Player> players) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<>(players);
    }

    public Player startGame() {
        while (true) {
            Player currentPlayer = players.poll();
            board.printBoard();
            int row, col;
            while (true) {
                System.out.println(currentPlayer.getName() + ", enter row and column (0-indexed): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (board.addPiece(row, col, currentPlayer.getPieceType())) {
                    break;
                }
                System.out.println("Invalid move. Try again.");
            }

            if (isThereAWinner(currentPlayer.getPieceType())) {
                return currentPlayer;
            }
            if (!board.hasFreeCell()) {
                return null; // draw
            }
            players.offer(currentPlayer); // back to end of queue for next round
        }
    }

    private boolean isThereAWinner(PieceType pieceType) {
        int n = board.getSize();

        // check rows
        for (int i = 0; i < n; i++) {
            boolean rowWin = true;
            for (int j = 0; j < n; j++) {
                if (board.getPiece(i, j) != pieceType) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        // check columns
        for (int j = 0; j < n; j++) {
            boolean colWin = true;
            for (int i = 0; i < n; i++) {
                if (board.getPiece(i, j) != pieceType) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        // main diagonal (top-left to bottom-right)
        boolean diagWin = true;
        for (int i = 0; i < n; i++) {
            if (board.getPiece(i, i) != pieceType) {
                diagWin = false;
                break;
            }
        }
        if (diagWin) return true;

        // anti-diagonal (top-right to bottom-left)
        diagWin = true;
        for (int i = 0; i < n; i++) {
            if (board.getPiece(i, n - 1 - i) != pieceType) {
                diagWin = false;
                break;
            }
        }
        return diagWin;
    }
}
