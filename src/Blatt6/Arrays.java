package Blatt6;

public class Arrays {

    public static void main(String[] args){
        int[] n = create(10);
        swapPairs(n);
        System.out.println("Summe ungerade Zahlen: "+sumOdd(new int[]{3, 4, 5, 7, 9 ,13}));
    }

    static int[] create(int n){
        int[] arr = new int[n];
        int start = 1;
        for(int i = 0; i < arr.length; i++){
            arr[i] = start;
            start *= 2;
        }
        return arr;
    }

    static void swapPairs(int[] arr){
        int len = arr.length - arr.length%2;
        for(int i = 0; i < len-1; i++){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int sumOdd(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                sum =  sum + arr[i];
            }
        }
        return sum;
    }
}
