package pieces;

import player.Spot;

public class Rook extends Piece{

    private static final String name = "Rook";

    public Rook(Spot spot, String id, boolean isWhite) {
        super(name, spot, id, isWhite);
    }
}
