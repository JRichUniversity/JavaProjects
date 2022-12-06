package Blatt6;
import Blatt5.Substituition;

import static jsTools.Input.*;

public class Matrix {
    static int[][] MATRIX;
    static String PATH = "src/Blatt6/Mat0Input.txt";

    public static void main(String[] args){
        MATRIX = readMatrix(PATH);
        getMin(MATRIX);
    }

    public static int[][] readMatrix(String path){
        String[] lines = Substituition.readFile(path);
        int x = lines.length;
        int y = lines[1].split(", ").length;
        int[][] matrix = new int[x][y];
        for(int i = 0; i < x; i++){
            String[] line = lines[i].split(", ");
            for(int j = 0; j < y; j++){
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }

    public static int getMin(int[][] matrix){
        int min = 0;
        int[] pos = {0,0};
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) { // <- Hier müsste "<=" stehen
                    min = matrix[i][j];
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        System.out.println("Kleinste Zahl: " + min + " an Postion matrix[" + pos[0] + "][" + pos[1] + "]");
        return min;
    }

}
