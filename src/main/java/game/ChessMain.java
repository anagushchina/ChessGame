package game;

import pieces.King;
import pieces.Knight;
import pieces.Piece;
import pieces.Rook;
import player.Player;
import player.Spot;

import java.util.ArrayList;
import java.util.HashMap;

public class ChessMain {

    public static void main(String[] args) {

        ChessMain game = new ChessMain();

        ArrayList<Player> players = game.createPlayers();
        for (Player player : players) {
            System.out.println("Created player: " + player);
        }

        HashMap<String, Piece> pieceHashMap = game.createBoard();
        System.out.println("Created Board: " + pieceHashMap);

        game.whitePlayerMoves(pieceHashMap, "white_king", "A", 5);
        game.whitePlayerMoves(pieceHashMap, "black_king", "D", 5);
        game.blackPlayerMoves(pieceHashMap, "black_king", "C", 3);

        players.get(0).setPlayerRank(3000);
    }


    public ArrayList<Player> createPlayers(){
        Player whitePlayer = new Player("Beth Harmon", "bethharmon@gmail.com", true, 2000, 20);
        Player blackPlayer = new Player("Vasily Borgov", "vasily.borgov@yandex.ru", false, 2500, 45);
        ArrayList<Player> players = new ArrayList<>();
        players.add(whitePlayer);
        players.add(blackPlayer);
        return players;
    }

    public HashMap<String, Piece> createBoard(){
        King whiteKing = new King(new Spot("h", 7), "white_king", true);
        King blackKing = new King(new Spot("d", 8), "black_king", false);
        Rook whiteRook1 = new Rook(new Spot("g", 7), "white_rook1", true);
        Rook blackRook1 = new Rook(new Spot("g", 7), "black_rook1", false);
        Rook whiteRook2 = new Rook(new Spot("a", 7), "white_rook2", true);
        Rook blackRook2 = new Rook(new Spot("a", 7), "black_rook2", false);
        Knight blackKnight = new Knight(new Spot("d", 6), "black_knight", false);
        Knight whiteKnight = new Knight(new Spot("c", 2), "white_knight", true);

        HashMap<String, Piece> pieceHashMap = new HashMap<>();
        pieceHashMap.put(whiteKing.getId(), whiteKing);
        pieceHashMap.put(blackKing.getId(), blackKing);
        pieceHashMap.put(whiteRook1.getId(), whiteRook1);
        pieceHashMap.put(blackRook1.getId(), blackRook1);
        pieceHashMap.put(whiteRook2.getId(), whiteRook2);
        pieceHashMap.put(blackRook2.getId(), blackRook2);
        pieceHashMap.put(blackKnight.getId(), blackKnight);
        pieceHashMap.put(whiteKnight.getId(), whiteKnight);
        return pieceHashMap;
    }

    public void whitePlayerMoves(HashMap<String, Piece> pieceHashMap, String piece, String x, int y){
        try{
            System.out.printf("White player moves %s to %s%d%n", piece, x, y);
            createPlayers().get(0).movePiece(pieceHashMap.get(piece), new Spot(x, y));
        } catch(IllegalArgumentException error){
            System.out.println("The incorrect move. Please try again");
        }
    }

    public void blackPlayerMoves(HashMap<String, Piece> pieceHashMap, String piece, String x, int y){
        try{
            System.out.printf("Black player moves %s to %s%d%n", piece, x, y);
            createPlayers().get(1).movePiece(pieceHashMap.get(piece), new Spot(x, y));
        } catch(IllegalArgumentException error){
            System.out.println("The incorrect move. Please try again");
        }
    }
}
