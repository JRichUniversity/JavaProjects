package com.company;

public class Soduko {

    private static int BOARD_SIZE = 9;
    private static int MIN_NUM = 1;
    private static int MAX_NUM = 9;

    public static void main(String[] args){
        int board[][] = {
                { 0, 0, 0, 7, 0, 1, 0, 0, 0 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 4, 0, 2, 6, 3, 0, 9, 5 },
                { 0, 0, 6, 1, 0, 9, 2, 0, 0 },
                { 4, 0, 0, 0, 0, 0, 0, 0, 6 },
                { 0, 0, 5, 6, 0, 8, 9, 0, 0 },
                { 8, 2, 0, 4, 1, 7, 0, 6, 9 },
                { 9, 0, 0, 0, 5, 0, 0, 0, 3 },
                { 0, 0, 0, 9, 0, 6, 0, 0, 0 } };

        if (solve(board, 0, 0))
            print(board);
        else
            System.out.println("No Solution exists");
    }

    static boolean solve(int board[][], int row , int col){
        if(row == BOARD_SIZE - 1 && col == BOARD_SIZE) return true;
        if(col == BOARD_SIZE){
            row++;
            col = 0;
        }
        if(board[row][col] != 0){
            return solve(board, row , col+1);
        }
        for(int num = MIN_NUM; num <= MAX_NUM; num++){
            if(isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if(solve(board, row, col + 1)){
                    return true;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        return checkRow(board, row, col, num) && checkCol(board, row, col, num) && checkBlock(board, row, col, num);
    }

    static boolean checkRow(int[][] board, int row, int col, int num){
        for(int i = 0; i < BOARD_SIZE;i++){
            if(board[row][i] == num){
                return false;
            }
        }
        return true;
    }

    static boolean checkCol(int[][] board, int row, int col, int num){
        for(int j = 0; j < BOARD_SIZE; j++){
            if(board[j][col] == num){
                return false;
            }
        }
        return true;
    }

    static boolean checkBlock(int[][] board, int row, int col, int num){
        int startRow = row - row % 3, startCol = col - col % 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i+startRow][j+startCol] == num){
                    return false;
                }
            }
        }
        return true;
    }

    static void print(int[][] board)
    {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
