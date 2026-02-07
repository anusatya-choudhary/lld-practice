import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.PieceType;

import java.util.Arrays;
import java.util.List;

public class TicTacToeDemo {

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new Player("Alice", PieceType.X),
                new Player("Bob", PieceType.O)
        );
        Game game = new Game(3, players);
        Player winner = game.startGame();

        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a draw.");
        }
    }
}
