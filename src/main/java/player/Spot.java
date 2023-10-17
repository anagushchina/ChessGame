package player;

public class Spot {

    String x;
    int y;

    public Spot(String x, int y) {
        if(x.compareTo("h") > 0 || y > 8 || y <= 0){
            throw new IllegalArgumentException("Incorrect spot error, expected x must be from A to H, y from 1 to 8. Actual x is " + x + " actual y is " + y);
        }
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" +
                "x='" + x + '\'' +
                ", y=" + y +
                '}';
    }
}
