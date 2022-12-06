package Blatt6;
import static jsTools.Input.*;

public class LongArray {
    static long[][] arr;
    static int finale;

    public static void main(String[] args){
        finale = readInt("Bitte einen n x n Wert eingeben: ");
        arr = new long[finale][finale];
        prepareArray(arr);
    }

    public static void prepareArray(long[][] array){
        for(int i = 0; i < array.length; i++){
            array[i][0] = 1;
            array[0][i] = 1;
        }
        for(int i = 1; i < array.length; i++){
            for(int j = 1; j < array.length; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        for(long[] width : arr){
            for(long num : width){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
