import java.util.ArrayList;
import java.util.HashMap;

public class ChessMain {

    public static void main(String[] args) {

        ChessMain chessMain = new ChessMain();
        ArrayList<Player> players= chessMain.createPlayers();
        for(Player player: players){
            System.out.println(player);
        }

        HashMap<String, Piece> pieceHashMap = chessMain.createPieces();
        System.out.println(pieceHashMap);

        chessMain.play(players, pieceHashMap);



//        System.out.println(whitePlayer.getPlayerName() + " " + whitePlayer.getPlayerEmail() + " " + whitePlayer.getIsPieceWhite() + " " + whitePlayer.getPlayerRank() + " " + whitePlayer.getPlayerAge());
//        System.out.println(blackPlayer);
//
//        try{
//        whitePlayer.setPlayerRank(10000);}
//        catch (Exception err) {
//            System.out.println("Please write a valid rank");
//        }
//
//        blackPlayer.setPlayerRank(2600);
//
//        System.out.println(whitePlayer.getPlayerRank());

    }
    public ArrayList<Player> createPlayers(){
        Player whitePlayer = new Player("Beth Harmon", "bethharmon@gmail.com", true, 2000, 20);
        Player blackPlayer = new Player("Vasily Borgov", "vasily.borgov@yandex.ru", false, 2500, 45);
        ArrayList<Player> players = new ArrayList<>();
        players.add(whitePlayer);
        players.add(blackPlayer);
        return players;
    }

    public HashMap<String, Piece> createPieces(){
        King whiteKing = new King(new Spot("h", 7), "white_king", true);
        King blackKing = new King(new Spot("d", 8), "black_king", false);
        Rook whiteRook1 = new Rook(new Spot("g", 7), "white_rook1", true);
        Rook whiteRook2 = new Rook(new Spot("a", 7), "white_rook2", true);
        King blackKnight = new King(new Spot("d", 6), "black_knight", false);

        HashMap<String, Piece> pieceHashMap = new HashMap<>();
        pieceHashMap.put(whiteKing.getId(), whiteKing);
        pieceHashMap.put(blackKing.getId(), blackKing);
        pieceHashMap.put(whiteRook1.getId(), whiteRook1);
        pieceHashMap.put(whiteRook2.getId(), whiteRook2);
        pieceHashMap.put(blackKnight.getId(), blackKnight);

        return pieceHashMap;
    }

    public void play (ArrayList<Player> players, HashMap<String, Piece> pieceHashMap){
        try{
        players.get(1).movePiece(pieceHashMap.get("white_rook1"), new Spot("a", 8));}
        catch(IllegalArgumentException error){
            System.out.println("The incorrect move. Please try again");
        };
        //retry functionality
        players.get(1).movePiece(pieceHashMap.get("black_knight"), new Spot("c", 8));
    }
}
