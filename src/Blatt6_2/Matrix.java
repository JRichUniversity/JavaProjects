package Blatt6_2;

public class Matrix {
    static long[][] matrix;

    public static void main(String[] args){
        matrix(10);
    }

    static void matrix(int n){
        matrix = new long[n][n];
        for(int i = 0; i < matrix[0].length; i++){
            matrix[0][i] = 1;
            matrix[i][0] = 1;
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        for(long[] line : matrix){
            for(long l : line){
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
