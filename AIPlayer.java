
public class AIPlayer implements Player {


   
    private int columns;
    private int rows;
    private int player_ID;
    private Board board = new Board();
    private char[][] board1;
    private int opponent_ID;
    private int currentColumn;
    private int firstPlay;

    //constructor takes the player id for this player, and the number of 
    // rows and columns of the board we're playing on
    public AIPlayer(int playerID, int row, int col) {

        this.player_ID = playerID;
        this.rows = row;
        this.columns = col;
        this.currentColumn = 0;
        this.firstPlay = 0;
        board = new Board(rows, columns);

        if (player_ID == 1) {

            opponent_ID = 2;
        } else {
            opponent_ID = 1;
        }

    }

    //used to notify your AI player of the other players last move
    public void lastMove(int c) {

        this.currentColumn = c;
        firstPlay++;

    }

    //returns column of where to play a token
    public int playToken() {

        int counter = 0;
        int tokenPlacement = 0;
        int x = 0;

        int randomToken = (int) Math.floor(Math.random() * columns);

        if (firstPlay > 0) {

            board.play(opponent_ID, currentColumn);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (board.getToken(i, j) != ' ') {

                    counter++;
                }

            }

        }
        
        
         if (counter == 0) {

            tokenPlacement = randomToken;
            board.play(player_ID, tokenPlacement);
            return tokenPlacement;
        }

        if (counter == 1) {

            if (currentColumn <= columns - 3 || currentColumn == 0) {

                tokenPlacement = currentColumn + 2;
                board.play(player_ID, tokenPlacement);
                return tokenPlacement;
            } else {
                tokenPlacement = currentColumn - 2;
                board.play(player_ID, tokenPlacement);
                return tokenPlacement;
            }
        }
        

        // VERTICAL
        for (int j = 0; j < columns; j++) {
            for (int i = rows - 1; i >= 0; i--) {

                if (board.getToken(i, j) != ' ' && (board.getToken(i, j) == board.getToken(i - 1, j)) && (board.getToken(i - 1, j) == board.getToken(i - 2, j))) {
                    tokenPlacement = j;
                    if (board.getToken(0, tokenPlacement) == ' ') {
                        board.play(player_ID, tokenPlacement);
                        return tokenPlacement;
                    } else {
                        while (x == 0) {

                            randomToken = (int) Math.floor(Math.random() * columns);
                            if (board.getToken(0, randomToken) == ' ') {
                                tokenPlacement = randomToken;
                                board.play(player_ID, tokenPlacement);
                                x++;
                                return tokenPlacement;
                            }

                            x = 0;
                        }

                    }
                }
            }
        }

        // HORIZONTAL
        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < columns; l++) {

                if (board.getToken(l, k) != ' ' && (board.getToken(l, k) == board.getToken(l, k + 1)) && (board.getToken(l, k + 1) == board.getToken(l, k + 2))) {
                    if (l == 0) {
                        tokenPlacement = l + 3;
                        board.play(player_ID, tokenPlacement);
                        return tokenPlacement;
                    } else {
                        tokenPlacement = l - 1;
                        if (board.getToken(0, tokenPlacement) == ' ') {
                            board.play(player_ID, tokenPlacement);
                            return tokenPlacement;
                        } else {
                            while (x == 0) {

                                randomToken = (int) Math.floor(Math.random() * columns);
                                if (board.getToken(0, randomToken) == ' ') {
                                    tokenPlacement = randomToken;
                                    board.play(player_ID, tokenPlacement);
                                    x++;
                                    return tokenPlacement;
                                }

                                x = 0;
                            }
                        }
                    }
                }
            }
        }

        while (x == 0) {

            randomToken = (int) Math.floor(Math.random() * columns);
            if (board.getToken(0, randomToken) == ' ') {
                tokenPlacement = randomToken;
                board.play(player_ID, tokenPlacement);
                x++;
                return tokenPlacement;
            }

            x = 0;
        }

        return 100;

    }

//get this player's id
    public int getPlayerID() {

        return player_ID;
    }

    //resets the state of the player in preparation for a new game
    public void reset() {

        board = new Board();
    }

}
