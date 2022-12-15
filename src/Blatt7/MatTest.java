package Blatt7;

public class MatTest {

    public static void main(String[] args){
        int[][] gen = genMatrix(10, 5);
        for(int[] line : gen){
            for(int i : line){
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println();

        Person p1 = new Person(1, "Manuel Baum", 86368, "Gersthofen");
        p1.printInfo();
        Person p2 = new Person(2, "Kilian Baum", 86368, "Augsburg");
        p2.printInfo();

        System.out.println();

        Auto a1 = new Auto();
        Auto a2 = new Auto();
        a1.readValues();
        a2.init("Volvo", 200, 100, 2431, 2004);
        a1.print();
        a2.print();
        a2.driveTo(100, 200);
        a2.print();
    }

    static int[][] genMatrix(int n, int m){
        int[][] matrix = new int[n][m];
        for(int i = 0; i < matrix.length-1; i++){
            for(int j = 0; j < matrix[i].length-1; j++){
                matrix[i][j] = 1;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            matrix[i][matrix[i].length-1] = 100;
        }
        for(int i = 0; i < matrix[matrix.length-1].length; i++){
            matrix[matrix.length-1][i] = 100;
        }
        return matrix;
    }
}
