import java.util.ArrayList;
import java.util.Scanner;

public class Players {
    private static int playersCount; //number of players
    private static ArrayList<Character> pieces; //pieces of each player

    /**
     * One argument Constructor
     * @param numberOfPlayers to instantiate board
     */
    Players(int numberOfPlayers){
        playersCount = numberOfPlayers;
    }

    /**
     * Accessor
     * @return number of players
     */
    public static int getPlayersCount(){
        return playersCount;
    }

    /**
     * Mutator.
     * Asks the user for each player's piece, save it and checks for repeats
     */
    public void setGamePieces()
    {
        Scanner in = new Scanner (System.in);
        pieces = new ArrayList<>(); //Instantiate ArrayList for players' pieces
        int i = 1; //start from 1 because will call for example player 1, 2, etc.
        System.out.println();
        while( i <= playersCount) {
            System.out.print("Please enter piece of player " + i + ": "); //ask
            String piece = in.next(); //get input
            in = new Scanner(System.in); //clear scanner
            if(isRepeatPiece(piece.charAt(0))){ //check if the piece is repeated
                System.out.println("\nThe piece entered is already taken. "); //ask again
            }
            else{
                pieces.add(piece.charAt(0)); // else add
                i++;
            }
        }
    }

    /**
     * Checks for repeated games pieces
     * @param piece to be checked
     * @return true if is a repeat piece, else false
     */
    private boolean isRepeatPiece(char piece){
        for (Character character : pieces) {
            if (character == piece) {
                return true;
            }
        }
        return false;
    }

    /**
     * Iterate through the ArrayList of pieces and keep calling the players to enter their moves
     * @param player number. Ex: player1 game piece was 'x' hence x's player number is 1.
     */
    public static void callNextPlayer(int player) {
        System.out.print("Player \""+ pieces.get(player) + "\" please enter row and column position: ");
    }


    /**
     * Access the ArrayList of game pieces and return the requested one to place it in the board
     * @param playerNumber to request its piece
     * @return the char or piece
     */
    public static char getPlayersPieces(int playerNumber){
        return pieces.get(playerNumber);
    }
}

