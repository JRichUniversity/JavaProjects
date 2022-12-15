package Blatt6;

import jsTools.Input;

public class Soduko {
    static int[][] MATRIX = Matrix.readMatrix("src/Blatt6/Soduko.txt");

    public static void main(String[] args){
        print(MATRIX);
        findNum();
    }

    public static void findNum(){
        for(int i = 0; i < MATRIX.length; i++){
            for(int j = 0; j < MATRIX.length; j++){
                if(MATRIX[i][j] == 0){
                    MATRIX[i][j] = findFirstEqual(isZifferInZeileVorhanden(MATRIX, i), isZifferInSpalteVorhande(MATRIX, j), checkBlock(MATRIX, i, j, MATRIX[i][j]));
                }
            }
        }
        print(MATRIX);
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

    public static int findFirstEqual(boolean[] row, boolean[] col, boolean block){
        for(int i = 1; i < row.length; i++){
            if(row[i] == false && col[i] == false && !block){
                return i;
            }
        }
        return 0;
    }


    public static boolean[] isZifferInZeileVorhanden(int[][] matrix, int num){
        boolean[] isInLine = new boolean[10];
        int[] line = matrix[num];
        int numAtPos = 0;

        for(int i = 0; i < line.length; i++){
            numAtPos = line[i];
            if(numAtPos != 0){
                isInLine[numAtPos] = true;
            }
        }
        return isInLine;
    }

    public static boolean[] isZifferInSpalteVorhande(int[][] matrix, int num){
        boolean[] isInLine = new boolean[10];
        int[] col = new int[9];
        int pos = 0;
        int numAtPos = 0;

        for(int[] line : matrix){
            col[pos++] = line[num];
        }

        for(int i = 0; i < col.length; i++){
            numAtPos = col[i];
            if(numAtPos != 0){
                isInLine[numAtPos] = true;
            }
        }
        return isInLine;
    }

    static void print(int[][] field){
        int countX = 0;
        int countY = 0;
        System.out.println("-".repeat(25));
        for(int[] line : field){
            System.out.print("| ");
            for(int i : line){
                System.out.print(i + " ");
                countX++;
                if(countX == 3){
                    System.out.print("| ");
                    countX = 0;
                }
            }
            System.out.println();
            countY++;
            if(countY == 3){
                System.out.println("-".repeat(25));
                countY = 0;
            }
        }
    }
}
