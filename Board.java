
public class Board {

    private int rows = 6;
    private int columns = 7;
    private char[][] board;
    private char playerOne = 'X';
    private char playerTwo = 'O';

    public Board() {

        this.rows = 6;
        this.columns = 7;
        this.playerOne = 'X';
        this.playerTwo = 'O';
        this.board = new char[rows][columns];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }

    }

    public Board(int row, int col) {

        this.rows = row;
        this.columns = col;
        this.playerOne = 'X';
        this.playerTwo = 'O';

        this.board = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ' ';
            }
        }

    }

    public Board(int row, int col, char playerOne, char playerTwo) {

        this.rows = row;
        this.columns = col;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        this.board = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ' ';
            }
        }

    }

    public int getNumRows() {

        return rows;
    }

    public int getNumCols() {

        return columns;
    }

    public char getPlayerOne() {

        return playerOne;
    }

    public char getPlayerTwo() {

        return playerTwo;
    }

    public void setPlayerOne(char o) {

        playerOne = o;
    }

    public void setPlayerTwo(char t) {

        playerTwo = t;
    }

    public char getToken(int row, int col) {

        if (row > rows || col > columns || rows < 0 || columns < 0) {

            return '\0';
        }

        return board[row][col];
    }

    public boolean canPlay() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (board[i][j] == ' ') {

                    return true;
                }

            }
        }

        return false;

    }

    public boolean play(int p, int c) {

        if (p == 1 && c >= 0 && c < columns) {

            for (int i = (rows - 1); i >= 0; i--) {

                if (board[i][c] == ' ') {
                    board[i][c] = playerOne;
                    return true;
                }
                
            }
        } else if (p == 2 && c >= 0 && c < columns) {

            for (int i = (rows - 1); i >= 0; i--) {

                if (board[i][c] == ' ') {
                    board[i][c] = playerTwo;
                    return true;
                }
                
            }

        }

        return false;

    }

    public int checkHorizontal() {

        int count = -1;
        char check = board[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (board[i][j] == check) {

                    count++;
                } else {

                    count = 1;

                }

                check = board[i][j];

                if (count == 4 && check == playerOne) {
                    return 1;
                }
                if (count == 4 && check == playerTwo) {

                    return 2;
                }

            }

        }

        return -1;
    }

    public int checkVertical() {

        int count = -1;
        char check = board[0][0];

        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {

                if (board[i][j] == check) {

                    count++;
                } else {

                    count = 1;

                }

                check = board[i][j];

                if (count == 4 && check == playerOne) {
                    return 1;
                }
                if (count == 4 && check == playerTwo) {

                    return 2;
                }

            }

        }

        return -1;
    }

    public int checkDiagonalOne() {

        int count = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if ((i + 3) < rows && (j + 3) < columns && board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]) {

                    count = 4;

                }

                if (count == 4 && board[i][j] == playerOne) {
                    return 1;
                }
                if (count == 4 && board[i][j] == playerTwo) {

                    return 2;
                }

                count = 1;

            }
        }

        return -1;

    }

    public int checkDiagonalTwo() {

        int count = 1;

        for (int i = (rows - 1); i >= 0; i--) {
            for (int j = (columns - 1); j >= 0; j--) {

                if ((i - 3) > rows && (j - 3) > columns && board[i][j] == board[i - 1][j - 1] && board[i - 1][j - 1] == board[i - 2][j - 2] && board[i - 2][j - 2] == board[i - 3][j - 3]) {

                    count = 4;

                }

                if (count == 4 && board[i][j] == playerOne) {
                    return 1;
                }
                if (count == 4 && board[i][j] == playerTwo) {

                    return 2;
                }

                count = 1;

            }
        }

        return -1;

    }

    public int isFinished() {

        if (canPlay() == true) {

            if (checkHorizontal() == 1 || checkVertical() == 1 || checkDiagonalOne() == 1 || checkDiagonalTwo() == 1) {

                return 1;

            }

            if (checkHorizontal() == 2 || checkVertical() == 2 || checkDiagonalOne() == 2 || checkDiagonalTwo() == 2) {

                return 2;
            }

            if (checkHorizontal() == -1 && checkVertical() == -1 && checkDiagonalOne() == -1 && checkDiagonalTwo() == -1) {

                return -1;
            }
            
        }

            if (canPlay() == false) {

                if (checkHorizontal() == 1 || checkVertical() == 1 || checkDiagonalOne() == 1 || checkDiagonalTwo() == 1) {

                    return 1;

                }

                if (checkHorizontal() == 2 || checkVertical() == 2 || checkDiagonalOne() == 2 || checkDiagonalTwo() == 2) {

                    return 2;
                }

                if (checkHorizontal() == -1 && checkVertical() == -1 && checkDiagonalOne() == -1 && checkDiagonalTwo() == -1) {

                    return 0;

                }
            
            }

                return -1;

             
            
        

        }
        
    
    public char[][] getArray(){
        
        return board;
    
    }
    
    
    
    }
    

