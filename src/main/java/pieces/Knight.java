package pieces;

import player.Spot;

public class Knight extends Piece{

    private static final String name = "Knight";

    public Knight(Spot spot, String id, boolean isWhite) {
        super(name, spot, id, isWhite);
    }
}
