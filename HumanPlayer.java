
public class HumanPlayer implements Player {


    private int columns;
    private int rows;
    private int player_ID;
    private Board board = new Board();
    private char[][] board1;
  
    
    

    //constructor takes the player id for this player, and the number of 
    // rows and columns of the board we're playing on
    public HumanPlayer(int playerID, int row, int col) {

        this.player_ID = playerID;
        this.rows = row;
        this.columns = col;
        board = new Board();
        this.board1 = new char[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board1[i][j] = ' ';
            }
        }

    }

    //used to notify your AI player of the other players last move
    public void lastMove(int c) {
        
        int tokenLocation = c;

    }

    //returns column of where to play a token
    public int playToken() {
        
        System.out.println("Which column would you like to place your token?");
         int tokenLocation = IO.readInt();
         
        if (tokenLocation < 0 || tokenLocation >= columns) {

            System.out.print("Please re-enter a correct column number.");
            tokenLocation = IO.readInt();
        }

        if ((board.getToken(0,tokenLocation))!= ' '){
            System.out.print("Please re-enter a correct column number.");
            tokenLocation = IO.readInt(); }
        
         
       
        
        
        board.play(player_ID, tokenLocation);
        
        return tokenLocation;
    }
            

    public int getPlayerID() {

        return player_ID;

    }

    //resets the state of the player in preparation for a new game
    public void reset() {

        char[][] board1 = new char[rows][columns];

    }

}
