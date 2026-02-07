package tictactoe.model;

public enum PieceType {
    X, O;
}


public class Piece {
    private final PieceType pieceType;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
