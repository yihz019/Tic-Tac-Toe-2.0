import java.util.InputMismatchException;
import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main (String[] args) {
        Scanner in;
        int input; //take inputs
        boolean isDigit;
        boolean inRange;
        Logic logic = new Logic(); //instantiate logic object
        do {
            System.out.print("Please enter number of players (min: 3, max: 10): ");
            isDigit = true;
            inRange = true;
            in = new Scanner(System.in); //instantiate / clear scanner
            try {
                if (in.hasNextInt()){
                    input = in.nextInt();
                    if (input <= 10 && input >= 3) {
                        Players players = new Players(input); //set number of players
                        players.setGamePieces(); //ask for players pieces
                        System.out.println();
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                }
                else {
                    throw new InputMismatchException();
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("\nOut of Bounds.");
                inRange = false;
            }
            catch(InputMismatchException e){
                System.out.println("\nPlease enter integer only.");
                isDigit = false;
            }
        } while (!inRange || !isDigit);

        //Create Board object
        Board board = new Board(Players.getPlayersCount()+1, Players.getPlayersCount()+1);
        do{
            in = new Scanner(System.in); //clear scanner
            System.out.print("How many pieces in a row determines a winner (min: 3" +", max: " + (Players.getPlayersCount()+1) + "): ");
            inRange = true;
            isDigit = true;
            try {
                if (in.hasNextInt())
                {
                    input = in.nextInt();
                    if (input >= 3 && input <= Players.getPlayersCount() + 1) {
                        logic.setWinnerInRow(input);
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new InputMismatchException();
                }
            }
            catch(IllegalArgumentException e) {
                System.out.println("\nOut of range.");
                inRange = false;
            }
            catch(InputMismatchException e) {
                System.out.println("\nPlease enter integer only."); //if input is character or any symbol
                isDigit = false;
            }
        } while(!inRange || !isDigit);


        //calculate how many boxes/spots there are in the board to determine when a TIE happens
        final int spots = (Players.getPlayersCount()+1) * (Players.getPlayersCount()+1);

        board.drawBoard();

        int i = 0; // to count how many spots are being filled
        int playerNumber = 0; //to call each player
        boolean winner = false;
        boolean tie = false;

        while (!winner && !tie)
        {
            int row = 0; int col = 0;
            int count = 0; //to only take two integers (row and col)
            isDigit = false; //to check moves

            while (!isDigit){
                isDigit = true;
                in = new Scanner(System.in); //clear scanner
                Players.callNextPlayer(playerNumber); //ask player to enter row and col (move)
                try {
                    while (count < 2) {
                        if(in.hasNextInt()){
                            if (count == 0) {
                                row = in.nextInt(); //take row first
                            } else {
                                col = in.nextInt();
                            }
                            count++;
                        }
                        else{
                            throw new InputMismatchException();
                        }
                    }
                }

                catch (InputMismatchException e) {
                    board.drawBoard();
                    System.out.println("\nEnter integer only please.");
                    isDigit = false;
                    count = 0;
                }
            }

            if(board.setPiece(row, col, playerNumber))
            {
                System.out.println();
                board.drawBoard();
                if (logic.checkWinner(logic.getWinnerInRow())){ //if true there is a winner, announce it
                    winner = true; //stop loop
                    System.out.println("       ======================================================");
                    System.out.println("                         \"" + logic.getWinnerPiece() + "\"" + " is the WINNER");
                    System.out.println("       ======================================================");
                }
                else{
                    i++; // increment spot filled
                    playerNumber++; //move to next player
                    if (i == spots){
                        board.tie(); //announce TIE
                        tie = true; //stop loop
                    }
                    if (playerNumber == Players.getPlayersCount()) {
                        playerNumber = 0; //to not go out of bound of the number of players
                    }
                }
            }
            else{ //if out of bounds or taken position
                board.drawBoard(); //draw valid board again after the invalid move
            }
        }
    }
}
