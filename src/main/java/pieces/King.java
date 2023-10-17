package pieces;

import player.Spot;

public class King extends Piece{

    private static final String name = "King";

    public King(Spot spot, String id, boolean isWhite) {
        super(name, spot, id, isWhite);
    }
}
