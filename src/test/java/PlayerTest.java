import game.ChessMain;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pieces.Piece;
import player.Player;
import player.Spot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class PlayerTest {

    private static  ArrayList<Player> players;
    private static HashMap<String, Piece> pieceHashMap;

    @BeforeAll
    public static void setUp(){
        ChessMain chessMain = new ChessMain();
        players = chessMain.createPlayers();
        pieceHashMap = chessMain.createBoard();
    }

    @Test
    public void validMoveTest(){
        players.get(0).movePiece(pieceHashMap.get("white_king"),new Spot("h", 8));
        Assertions.assertEquals(8,pieceHashMap.get("white_king").getSpot().getY());
    }

    @Test
    public void invalidPieceColorTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            players.get(0).movePiece(pieceHashMap.get("black_knight"),new Spot("h", 8));
        });
    }

    @Test
    public void invalidMoveTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
        players.get(0).movePiece(pieceHashMap.get("white_king"),new Spot("k", 8));
        });
    }

    @Test
    public void playerCreationSuccessTest(){
        Player whitePlayer = new Player("Beth Harmon", "bethharmon@gmail.com", true, 2000, 20);
        Assertions.assertEquals("Beth Harmon", whitePlayer.getPlayerName());
        Assertions.assertEquals("bethharmon@gmail.com", whitePlayer.getPlayerEmail());
        Assertions.assertTrue(whitePlayer.getIsPieceWhite());
        Assertions.assertEquals(2000, whitePlayer.getPlayerRank());
        Assertions.assertEquals(20, whitePlayer.getPlayerAge());
    }

    @ParameterizedTest
    @MethodSource("nameError")
    public void playerCreationIncorrectNameTest(String name){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Player(name, "bethharmon@gmail.com", true, 2000, 20);
        });
    }

    @ParameterizedTest
    @MethodSource("emailError")
    public void playerCreationIncorrectEmailTest(String email){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Player("Beth Harmon", email, true, 2000, 20);
        });
    }

    static Stream<String> nameError(){
        return Stream.of("", "  ", null);
    }

    static Stream<String> emailError(){
        return Stream.of("", "  ", null, "bethharmo", "bethharmongmail.com");
    }
}
