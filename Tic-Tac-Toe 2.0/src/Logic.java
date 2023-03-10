public class Logic {
    private int row;
    private int col;
    private int repeats; //keep track of repeated pieces and compare with how many ina row to win
    private static char winnerPiece; //to save the winner piece and be able to announce the winner
    private static int winnerInRow; //how many pieces in a row to determine winner

    /**
     * Default or empty constructor. Initialize all Instance variables
     */
    Logic(){
        row = 0;
        col = 0;
        repeats = 1;
    }

    /**
     * Check if there is a winner depending on how many pieces in a row determines it. Calls the methods that check vertically, horizontally, and diagonally wins
     * @param howManyInARow to determine a winner
     * @return true if there is a winner, else false
     */
    public boolean checkWinner(int howManyInARow){
        for (int r = 0; r < Players.getPlayersCount() + 1; r++) { //check each row
            for (int c = 0; c < Players.getPlayersCount() + 1; c++) //check each column
                {
                    if (Board.getSpot(r,c) != ' ') { //if is not empty, check
                        if (horizontal(r, c, howManyInARow)) {
                            return true;
                        }
                        else if (vertical(r, c, howManyInARow)) {
                            return true;
                        }
                        else if (diagonalRight(r, c, howManyInARow)) {
                            return true;
                        }
                        else if (diagonalLeft(r, c, howManyInARow)) {
                            return true;
                        }
                    }
                }
            }
            return false; //there is no winner
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
         * Checks if there is a winner horizontally
         * @param row start checking from this row
         * @param col start checking from this column
         * @param repeat how many in a row to win
         * @return true if there is a winner, else false
         */
        private boolean horizontal(int row, int col, int repeat){
            this.col = col; //save starting column, because we will keep changing if there is repeats
            this.repeats = 1;
            //as long as the checking doesn't go out of bounds
            while(row < Players.getPlayersCount() +1 && this.col+1 < Players.getPlayersCount() +1) {
                if (Board.getSpot(row,col) == Board.getSpot(row,this.col+1)) {
                    this.repeats++; // increment repeats, so when it hits the number entered by the user, there is a winner
                    this.col++; //go to the next columns if there is repeats
                    if(this.repeats == repeat){
                        winnerPiece = Board.getSpot(row,this.col);
                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            return false;
        }

        /**
         * Checks if there is a winner vertically
         * @param row start checking from this row
         * @param col start checking from this column
         * @param repeat how many repeated pieces in a row to win
         * @return true if there is a winner, else false
         */
        private boolean vertical(int row, int col, int repeat){
            this.row = row;
            this.repeats = 1;
            while(this.row +1 < Players.getPlayersCount() +1 && col < Players.getPlayersCount() +1)
            {
                if (Board.getSpot(row,col) == Board.getSpot(this.row+1,col)) {
                    this.row++;
                    this.repeats++;
                    if(this.repeats == repeat){
                        winnerPiece = Board.getSpot(this.row,col);
                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            return false;
        }

        /**
         * Checks if there is a winner diagonally to the right
         * @param row start checking from this row
         * @param col start checking from this column
         * @param repeat how many in a row to win
         * @return true if there is a winner, else false
         */
        private boolean diagonalRight(int row, int col, int repeat){
            this.row = row;
            this.col = col;
            this.repeats = 1;
            while(this.row +1 < Players.getPlayersCount()+1 && this.col +1 < Players.getPlayersCount()+1)
            {
                if (Board.getSpot(row,col) == Board.getSpot(this.row+1,this.col+1)) {
                    this.repeats++;
                    this.col++; this.row++;
                    if(this.repeats == repeat){
                        winnerPiece = Board.getSpot(this.row,this.col);
                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            return false;
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
         * Checks if there is a winner diagonally to the left
         * @param row start checking from this row
         * @param col start checking from this column
         * @param repeat how many in a row to win
         * @return true if there is a winner, else false
         */
        private boolean diagonalLeft(int row, int col, int repeat){
            this.row = row;
            this.col = col;
            this.repeats = 1;
            while((this.col -1 >=0 && this.col -1 < Players.getPlayersCount()+1)  && this.row +1< (Players.getPlayersCount()+1))
            {
                if (Board.getSpot(row,col) == Board.getSpot(this.row+1,this.col-1)) {
                    this.repeats++; this.row++; this.col--;
                    if(this.repeats == repeat){
                        winnerPiece = Board.getSpot(this.row,this.col);
                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            return false;
        }

        /**
         * Mutator method.
         * Save how many pieces in a row determines a winner once the user inputs it
         * @param piecesInRow to win
         */
        public void setWinnerInRow(int piecesInRow) {
             winnerInRow = piecesInRow;
        }

        /**
         * Accessor method.
         * @return how many in a row determines a winner
         */
        public int getWinnerInRow() {
            return winnerInRow;
        }

        /**
         * @return the winner piece to announce the winner
         */
        public char getWinnerPiece() {
            return winnerPiece;
        }
    }



