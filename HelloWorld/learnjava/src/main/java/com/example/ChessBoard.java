package com.example;

/**
 * Created by apahlavan1 on 1/7/2016.
 */



public class ChessBoard {
    private char[][] chessBoard;
    final int ORIGIN = 1;
    final char[] NUMBER_COL = {'1', '2', '3', '4', '5', '6', '7', '8'};
    final char[] LETTER_ROW = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    final int ROWS = 10;
    final int COLS = 10;
    final char QUEEN = 'Q';
    final char UNSAFE = 'X';
    final char EMPTY = ' ';
    final int RIGHT_UP_COL = 1 ;
    final int RIGHT_DOWN_COL = 1 ;
    final int LEFT_UP_COL = -1 ;
    final int LEFT_DOWN_COL = -1 ;
    final int RIGHT_UP_ROW = -1 ;
    final int RIGHT_DOWN_ROW = 1 ;
    final int LEFT_UP_ROW = -1 ;
    final int LEFT_DOWN_ROW = 1 ;

    final int LEFT_COL = -1;
    final int RIGHT_COL = 1;
    final int DOWN_COL = 0;
    final int UP_COL = 0;

    final int LEFT_ROW = 0;
    final int RIGHT_ROW = 0;
    final int DOWN_ROW = 1;
    final int UP_ROW = -1;

    public ChessBoard() {
        this.chessBoard = new char[ROWS][COLS];
        for (int tempRow = 0; tempRow < ROWS; tempRow += 1) {
            for (int tempCol = 0; tempCol < COLS; tempCol += 1) {
                    this.chessBoard[tempRow][tempCol] = EMPTY;
            }
        }

        for (int tempRow2 = 0; tempRow2 < ROWS; tempRow2 += 1) {

            for (int tempCol2 = 0; tempCol2 < COLS; tempCol2 += 1) {

                //Writing number borders
                if((tempCol2 == 0 || tempCol2 == 9) && tempRow2 < 8){
                    this.chessBoard[tempRow2 + ORIGIN][tempCol2] = NUMBER_COL[tempRow2];
                }
                if ((tempRow2 == 0 || tempRow2 == 9) && tempCol2 < 8) {
                        this.chessBoard[tempRow2][tempCol2 + ORIGIN] = LETTER_ROW[tempCol2];
                }
                if (tempRow2 < 8 && tempCol2 < 8) {
                        this.chessBoard[tempRow2 + ORIGIN][tempCol2 + ORIGIN] = EMPTY;
                }
            }
        }
    }

    public void setQueenOnPos(int row, int col) {
        this.chessBoard[row][col]  = QUEEN;
    }

    public boolean removeQueenFromPos(int row, int col){
        char[][] tempBoard = getChessBoard();
        boolean retVal = false;
        if (tempBoard[row][col] == QUEEN){
            tempBoard[row][col] = EMPTY;
            retVal = true;
        }
        return retVal;
    }

    public void setNopOnPos(int row, int col) {
        this.chessBoard[row][col]  = UNSAFE;
    }

    public boolean removeNopFromPos(int row, int col){
        char[][] tempBoard = getChessBoard();
        boolean retVal = false;
        if (tempBoard[row][col] == UNSAFE){
            tempBoard[row][col] = EMPTY;
            retVal = true;
        }
        return retVal;
    }

    public boolean replaceNopWithQueen(int row, int col){
        char[][] tempBoard = getChessBoard();
        boolean retVal = false;
        if (tempBoard[row][col] == UNSAFE){
            tempBoard[row][col] = QUEEN;
            retVal = true;
        }
        return retVal;
    }

    public boolean replaceQueenWithNop(int row, int col){
        char[][] tempBoard = getChessBoard();
        boolean retVal = false;
        if (tempBoard[row][col] == QUEEN){
            tempBoard[row][col] = UNSAFE;
            retVal = true;
        }
        return retVal;
    }


    public char[][] getChessBoard() {
        return chessBoard;
    }

    public void resetBoard(){

        //spasing out the board
        for (int tempRow = 0; tempRow < ROWS; tempRow += 1) {
            for (int tempCol = 0; tempCol < COLS; tempCol += 1) {
                this.chessBoard[tempRow][tempCol] = EMPTY;
            }
        }

        for (int tempRow2 = 0; tempRow2 < ROWS; tempRow2 += 1) {

            for (int tempCol2 = 0; tempCol2 < COLS; tempCol2 += 1) {

                //Writing number borders
                if((tempCol2 == 0 || tempCol2 == 9) && tempRow2 < 8){
                    this.chessBoard[tempRow2 + ORIGIN][tempCol2] = NUMBER_COL[tempRow2];
                }
                if ((tempRow2 == 0 || tempRow2 == 9) && tempCol2 < 8) {
                        this.chessBoard[tempRow2][tempCol2 + ORIGIN] = LETTER_ROW[tempCol2];
                }
                if (tempRow2 < 8 && tempCol2 < 8) {
                        this.chessBoard[tempRow2 + ORIGIN][tempCol2 + ORIGIN] = EMPTY;
                }
            }
        }

    }

    public int isEmptySquare(int row, int col){
        char result = getChessBoard()[row][col];
//        System.out.println("This is the result of isEmptySquare(): " + result);
        return result;
    }



    public int recEightQueenChallenge(int row, int col, int k, int n){
        if (row <= 0 || row >= 9 || col <= 0 || col >= 9){
            System.out.println("row: " + row + ", col: " + col);
            System.out.println("Error (ln 155): We are on a border... will return 0");
            return 0;
        }
//        printBoard();
        //base case:
        char[][] tempBoard = getChessBoard();


        if(n == 0){
            if(k == 0) {
                printBoard();
                System.out.println("We've got a k = 1");
                return 1;
            }
            return 0;
        }

        if(k == 0){
            printBoard();
            System.out.println("We've got a k = 1");
            return 1;
        }


        switch (isEmptySquare(row, col)){

            case UNSAFE:
                return 0;
            case QUEEN:
                return 0;
            case EMPTY:
                if(isSafe(row, col)){

                    tempBoard[row][col] = QUEEN;


                    // ROW = 1 ,,,, SAFE
                    if (row == 1){
                        if (col == 1){
                            return recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k-1, n-1) + //right
                                    recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k-1, n-1) + //right_down
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k-1, n-1); //down
                        }
                        else
                            if (col == 8) {
                                return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k - 1, n - 1) + //left
                                        recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k - 1, n - 1) + //left_down
                                        recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k - 1, n - 1); //down
                            }

                        else {
                                return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k - 1, n - 1) + //left
                                        recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k - 1, n - 1) + //left_down
                                        recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k - 1, n - 1) + //down
                                        recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k - 1, n - 1) + //right_down
                                        recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k - 1, n - 1); //right
                            }
                    }

                    // ROW = 8 ,,,, SAFE
                    if (row == 8){
                        if (col == 1){
                            return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k-1, n-1) + //UP
                                    recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k-1, n-1) + //right_up
                                    recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k-1, n-1); //right
                        }
                        else
                            if (col == 8){
                                return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k-1, n-1) + //left
                                        recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k-1, n-1) + //left_up
                                        recEightQueenChallenge(row + UP_ROW, col + UP_COL, k-1, n-1); //up
                            }
                        else {
                                return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k-1, n-1) + //left
                                        recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k-1, n-1) + //left_up
                                        recEightQueenChallenge(row + UP_ROW, col + UP_COL, k-1, n-1) + //up
                                        recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k-1, n-1) + //right_up
                                        recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k - 1, n - 1); //right
                            }
                    }

                    //COL = 1 ,,,, SAFE
                    if(col == 1){
                        if (row != 1 && row != 8){
                            return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k-1, n-1) + //up
                                    recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k-1, n-1) + //right_up
                                    recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k-1, n-1) + //right
                                    recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k-1, n-1) + //right_down
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k-1, n-1); //down
                        }
                    }

                    //COL = 15 ,,,, SAFE
                    if (col == 8){
                        if (row != 1 && row != 8){
                            return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k-1, n-1) + //up
                                    recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k-1, n-1) + //up_left
                                    recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k-1, n-1) + //left
                                    recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k-1, n-1) + //down_left
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k-1, n-1); //down
                        }
                    }

                    //EVERYWHERE ELSE ,,,, SAFE
                    {
                        return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k-1, n-1) + //up
                                recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k-1, n-1) + //up_left
                                recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k-1, n-1) + //left
                                recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k-1, n-1) + //down_left
                                recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k-1, n-1)  +//down
                                recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k-1, n-1) + //right_down
                                recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k-1, n-1) + //right
                                recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k-1, n-1); //right_up
                    }
                }
                //NOW WE KNOW IS NOT SAFE HERE SO:
                else {
                    tempBoard[row][col] = UNSAFE;
                    if (row == 0 || row == 9){
                        System.out.println("Error: We are on the Row border.");
                    }
                    if (col == 0 || col == 9){
                        System.out.println("Error: We are on the Col border.");
                    }

                    // ROW = 1 ... NOT SAFE
                    if (row == 1){
                        if (col == 1){
                            return recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k, n-1) + //right
                                    recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k, n-1)+ //right_down
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k, n-1); //down
                        }
                        else
                        if (col == 8) {
                            return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k, n - 1) + //left
                                    recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k, n - 1) + //left_down
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k , n - 1); //down
                        }

                        else {
                            return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k, n - 1) + //left
                                    recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k, n - 1) + //left_down
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k, n - 1) + //down
                                    recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k, n - 1) + //right_down
                                    recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k, n - 1); //right
                        }
                    }

                    // ROW = 8 ... NOT SAFE
                    if (row == 8){
                        if (col == 1){
                            return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k, n-1) + //UP
                                    recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k, n-1) + //right_up
                                    recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k, n-1); //right
                        }
                        else
                        if (col == 8){
                            return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k, n-1) + //left
                                    recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k, n-1) + //left_up
                                    recEightQueenChallenge(row + UP_ROW, col + UP_COL, k, n-1); //up
                        }
                        else {
                            return recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k, n-1) + //left
                                    recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k, n-1) + //left_up
                                    recEightQueenChallenge(row + UP_ROW, col + UP_COL, k, n-1) + //up
                                    recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k, n-1) + //right_up
                                    recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k, n - 1); //right
                        }
                    }

                    //COL = 1 ... NOT SAFE
                    if(col == 1){
                        if (row != 1 && row != 8){
                            return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k, n-1) + //up
                                    recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k, n-1) + //right_up
                                    recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k, n-1) + //right
                                    recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k, n-1) + //right_down
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k, n-1); //down
                        }
                    }

                    //COL = 15 ... NOT SAFE
                    if (col == 8){
                        if (row != 1 && row != 8){
                            return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k, n-1) + //up
                                    recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k, n-1) + //up_left
                                    recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k, n-1) + //left
                                    recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k, n-1) + //down_left
                                    recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k, n-1); //down
                        }
                    }

                    //EVERYWHERE ELSE ... NOT SAFE
                    {
                        return recEightQueenChallenge(row + UP_ROW, col + UP_COL, k, n-1) + //up
                                recEightQueenChallenge(row + LEFT_UP_ROW, col + LEFT_UP_COL, k, n-1) + //up_left
                                recEightQueenChallenge(row + LEFT_ROW, col + LEFT_COL, k, n-1) + //left
                                recEightQueenChallenge(row + LEFT_DOWN_ROW, col + LEFT_DOWN_COL, k, n-1) + //down_left
                                recEightQueenChallenge(row + DOWN_ROW, col + DOWN_COL, k, n-1)  +//down
                                recEightQueenChallenge(row + RIGHT_DOWN_ROW, col + RIGHT_DOWN_COL, k, n-1) + //right_down
                                recEightQueenChallenge(row + RIGHT_ROW, col + RIGHT_COL, k, n-1) + //right
                                recEightQueenChallenge(row + RIGHT_UP_ROW, col + RIGHT_UP_COL, k, n-1); //right_up
                    }
                }


            default:
                System.out.println("Default case error: Stepping on the border... wil return 0");
                return 0;
        }
    }

    public boolean isSafe(final int currRow, final int currCol) {
//        System.out.println("current column is: " + currCol + ", and current row is: " + currRow);

        char[][] tempBoard = getChessBoard();
        int tempRow, tempCol;

        //Vertical check:
        for (int row = 1; row < ROWS - 1; row += 1)
            if (tempBoard[row][currCol] == QUEEN)
                return false;


        //Horizontal check:
        for (int col = 1; col < COLS - 1; col += 1)
            if(tempBoard[currRow][col] == QUEEN)
                return false;


        //Diagonal check (i.e. '/' ):
        tempRow = 9 - currRow; //8 7 6 5 4 3 2 1
        tempCol = currCol; //1 2 3 4 5 6 7 8

        if (tempCol <= tempRow){
            tempRow = tempRow - tempCol;
            tempRow -= 1;
            tempCol = 1;
        }
        else {
            tempCol -= tempRow;
            tempCol += 1;
            tempRow = 1;
        }

        if (tempRow < 0)
            tempRow = (-tempRow);
        tempRow = 9 - tempRow; // 1 2 3 4 5 6 7 8

        while(tempCol < 9   && tempRow > 0 ) {

            if(tempBoard[tempRow][tempCol] == QUEEN) {
                return false;
            }

            tempCol += 1;
            tempRow -= 1;
        }

        //Diagonal check (i.e. '\' ):
        tempCol = currCol; //1 2 3 4 5 6 7 8
        tempRow = currRow; //1 2 3 4 5 6 7 8
        if (tempCol <= tempRow){
            tempRow -= tempCol;
            tempRow += 1;
            tempCol = 1;
        }
        else {
            tempCol -= tempRow;
            tempCol += 1;
            tempRow = 1;
        }


        while(tempCol < 9 && tempRow < 9){

            if(tempBoard[tempRow][tempCol] == QUEEN)
                return false;

            tempCol += 1;
            tempRow += 1;
        }

        return true;
    }


    public void printBoard(){

        for (int row = 0; row < ROWS; row += 1) {
            for (int col = 0; col < COLS; col += 1) {
                if(this.chessBoard[row][col] == UNSAFE)
                    this.chessBoard[row][col] = ' ';
                System.out.print(this.chessBoard[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println('\n');
    }

}
