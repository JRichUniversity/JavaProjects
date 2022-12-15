package Blatt6_2;

public class Soduko {

    static int board[][] = {
            { 0, 0, 0, 7, 0, 1, 0, 0, 0 },
            { 2, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 4, 0, 2, 6, 3, 0, 9, 5 },
            { 0, 0, 6, 1, 0, 9, 2, 0, 0 },
            { 4, 0, 0, 0, 0, 0, 0, 0, 6 },
            { 0, 0, 5, 6, 0, 8, 9, 0, 0 },
            { 8, 2, 0, 4, 1, 7, 0, 6, 9 },
            { 9, 0, 0, 0, 5, 0, 0, 0, 3 },
            { 0, 0, 0, 9, 0, 6, 0, 0, 0 } };

    public static void main(String[] args){
        printSodoku(board);
        printBooleanArray(isZahlInZeile(board, 2));
    }

    public static boolean[] isZahlInZeile(int[][] field, int zeile){
        boolean[] numbers = new boolean[10];
        for(int num : field[zeile]) numbers[num] = true; return numbers;
    }

    public static boolean[] isZahlInSpalte(int[][] field, int spalte){
        boolean[] numbers = new boolean[10];
        for(int i = 0; i < field.length; i++) numbers[field[i][spalte]] = true; return numbers;
    }

    static void printBooleanArray(boolean[] arr){
        int counter = 0;
        for(boolean b : arr) System.out.println(counter++ + ": " + b);
    }

    static void printSodoku(int[][] field){
        System.out.println("-".repeat(25));
        int countX = 0;
        int countY = 0;
        for(int[] line : field){
            System.out.print("| ");
            for(int i : line){
                System.out.print(i + " ");
                if(++countX == 3){
                    System.out.print("| ");
                    countX = 0;
                }
            }
            System.out.println();
            if(++countY == 3){
                System.out.println("-".repeat(25));
                countY = 0;
            }
        }
    }
}
