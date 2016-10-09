package com.example;

public class EightQueens {

    public static void main(String[] args) {
        ChessBoard myChessBoard = new ChessBoard();

        int index = 1, total = 0;
        for (int row = 1; row < 9; row += 1){
            for (int col = 1; col < 9; col += 1) {
                int result = myChessBoard.recEightQueenChallenge(row, col, 8, 64);
                if (result != 0)
                    myChessBoard.printBoard();
                System.out.println(index + ":  " + result);
                myChessBoard.resetBoard();
                index += 1;
                total += result;
            }
        }

        System.out.println(total);
    }

}
