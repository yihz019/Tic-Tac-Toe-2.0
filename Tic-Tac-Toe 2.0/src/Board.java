public class Board {
    private static char[][] board;

    /**
     * Constructor with 2 arguments, that Instantiates Board / Allocate and Initialize empty board
     * @param row which is number of players+1
     * @param col which is number of players+1
     */
    Board(int row, int col)
    {
        board = new char[row][col]; //allocate the 2D array for board
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++) {
                board[i][j] = ' '; //initialize empty board
            }
        }
    }

    /**
     * Draws the board with edges, enumerations of columns and rows, and prints a reminder of how many pieces in a row determines a winner
     */
    public void drawBoard(){
        System.out.print("   ");
        for (int i = 0; i < Players.getPlayersCount()+1; i++) // Enumerating columns
        {
            System.out.print("| " + i + " " ); // printing number of columns
        }

        System.out.println();
        for (int k = 0; k <= Players.getPlayersCount()+1; k++)
        {
            System.out.print("——  "); //draw edge
        }

        System.out.println();
        for (int i = 0; i < Players.getPlayersCount()+1; i++) //draw empty board
        {
            System.out.print(" " + i + " "); //enumerate each row
            for (int j = 0; j < Players.getPlayersCount()+1; j++) {
                System.out.print("| " + board[i][j] + " " );
                if( (i == 0 && j == Players.getPlayersCount()) || (i == 2 && j == Players.getPlayersCount()))
                {
                    System.out.print("        =============================== " );
                }
            }

            if (i == 1){
                Logic logic = new Logic();
                System.out.print("          REMINDER: " + logic.getWinnerInRow() + " in a row to win  " ); //how many in a row to win
            }
            System.out.println();
            if (i < Players.getPlayersCount() ){
                for (int k = 0; k <= Players.getPlayersCount() + 1; k++) {
                    System.out.print("——  "); //draw edge
                }
            }
            System.out.println();
        }
    }
//          | 0 | 1 | 2 | 3
//       ——  ——  ——  ——  ——
//        0 |   |   |   |           ===============================
//       ——  ——  ——  ——  ——
//        1 |   |   |   |             REMINDER: 3 in a row to win
//       ——  ——  ——  ——  ——
//        2 |   |   |   |           ===============================
//       ——  ——  ——  ——  ——
//        3 |   |   |   |



    /**
     * Sets players' pieces in the board as long as is not out of bounds and not a taken position
     * @param row The row that the player entered
     * @param col The column that the player entered
     * @param playersNumber The piece that represent the player
     * @return true if the position was successfully set, else false
     */
    public boolean setPiece(int row, int col, int playersNumber){
        if(outOfBounds(row,col)){
            System.out.println("\nNot valid move: Out of Bounds.");
            return false;
        }
        else if (positionTaken(row,col)){
            System.out.println("\nNot valid move: Position already taken. ");
            return false;
        }
        else {
            board[row][col] = Players.getPlayersPieces(playersNumber);
            return true;
        }
    }

    /**
     * Check if the position or spot given has already been taken or not
     * @param row to be checked
     * @param col to be checked
     * @return true if is taken, else false
     */
    private boolean positionTaken(int row, int col){
        return (board[row][col] != ' ');
    }

    /**
     * Check if the position given is out of bounds or is valid
     * @param row to be checked
     * @param col to be checked
     * @return true if is out of bounds, else false
     */
    private boolean outOfBounds(int row, int col){
        if (row > Players.getPlayersCount() && col > Players.getPlayersCount() || row < 0 && col < 0){
            return true;
        }
        else if (row > Players.getPlayersCount() || row < 0){ //if only row is out of bounds is still out of bounds
            return true;
        }
        else return (col > Players.getPlayersCount() || col < 0); //if only col is out of bounds is still out of bounds
    }

    /**
     * @param col column of the board
     * @param row row of the board
     * @return the char or element of that spot
     */
    public static char getSpot(int col, int row){
        return (board[row][col]);
    }

    /**
     * Will print TIE once all the spots in the board are filled but there is no winner
     */
    public void tie(){
        System.out.println("                 |—— —— —— ——|   —— —— —— ——   |—— —— —— ——|      ");
        System.out.println("                       |              |        |                  ");
        System.out.println("                       |              |        |                  ");
        System.out.println("                       |              |        |—— —— ——|         ");
        System.out.println("                       |              |        |                  ");
        System.out.println("                       |         —— —— —— ——   |—— —— —— ——|      ");
    }
}
