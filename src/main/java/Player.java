public class Player {

    private String playerName;
    private String playerEmail;
    private boolean isPlayerWhite;
    private int playerRank;
    private int playerAge;

    public String getPlayerName(){
        return playerName;
    }
    public String getPlayerEmail(){
        return playerEmail;
    }
    public boolean getIsPieceWhite(){
        return isPlayerWhite;
    }
    public int getPlayerRank(){
        return playerRank;
    }
    public int getPlayerAge(){
        return playerAge;
    }

    public Player (String name, String email, boolean isWhite, int rank, int age){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name should not be empty");
        }
        else {
            this.playerName = name;
        }

        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Email should not be empty");
        }
        else if(email.contains("@") == false || email.contains(".") == false){
            throw new IllegalArgumentException("Email should contain '@' and '.'");
        }
        else {
            this.playerEmail = email;
        }

        if(rank<100 || rank > 3000){
            throw new IllegalArgumentException("The rank should be in range of 100 and 3000");
        }
        else{
            this.playerRank =  rank;
        }

        if(age<18 || age>100){
            throw new IllegalArgumentException("The age should be in range of 18 and 100");
        }
        else{
            this.playerAge = age;
        }


        this.isPlayerWhite = isWhite;
    }

    public void setPlayerRank(int rank){
        if(rank<100 || rank > 3000){
            throw new IllegalArgumentException("The rank should be in range of 100 and 3000");
        }
        this.playerRank = rank;
        System.out.println("The rank of player " + playerName + " was change to " + playerRank);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerEmail='" + playerEmail + '\'' +
                ", isPieceWhite=" + isPlayerWhite +
                ", playerRank=" + playerRank +
                ", playerAge=" + playerAge +
                '}';
    }

    public void movePiece (Piece piece, Spot spot){
        if(isPlayerWhite != piece.isWhite()){
            throw new IllegalArgumentException("Incorrect piece color");
        }
        piece.setSpot(spot);
        System.out.println(piece.getPieceName() + " is moved to " + spot);;
    }




}
