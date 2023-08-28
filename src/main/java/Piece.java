public abstract class Piece {

    private String pieceName;
    private Spot spot;
    private String id;
    private boolean isWhite;
    private boolean isKilled;

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
    public void setKilled(boolean killed) {
        isKilled = killed;
    }


    public String getPieceName() {
        return pieceName;
    }
    public Spot getSpot() {
        return spot;
    }
    public String getId() {
        return id;
    }
    public boolean isWhite() {
        return isWhite;
    }
    public boolean isKilled() {
        return isKilled;
    }

    public Piece(String pieceName, Spot spot, String  id, boolean isWhite) {
        this.pieceName = pieceName;
        this.spot = spot;
        this.id = id;
        this.isWhite = isWhite;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceName='" + pieceName + '\'' +
                ", spot=" + spot +
                ", id='" + id + '\'' +
                ", isWhite=" + isWhite +
                ", isKilled=" + isKilled +
                '}';
    }
}
