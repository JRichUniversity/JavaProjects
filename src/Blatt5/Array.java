package Blatt5;

public class Array {
    static int[] numArr = new int[10];

    public static void main(String[] args){
        numArr = fillArr(numArr);
        printIntArr(numArr);
        numArr = switchArr(numArr, 0, 9);
        printIntArr(numArr);
    }

    public static int[] fillArr(int[] arr){
        int count = 0;
        for(int i : arr){
            arr[count] = count++;
        }
        return arr;
    }

    public static int[] switchArr(int[] arr, int index1, int index2){
        if(index1 >= 0 && index2 >= 0 && index1 <= arr.length-1 && index2 <= arr.length-1 && index1 != index2){
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        return arr;
    }

    public static void printIntArr(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
