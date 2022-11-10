package Blatt4P;
import java.util.ArrayList;

public class devision {

    public static void main(String[] args){
        modulo(12864);
        printPrimeFactors(12864);
    }

    public static void modulo(int num){
        int count = 0;
        for(int i = 2 ; i < num - 1; i++){
            if(num % i == 0){
                System.out.print(i + "\t");
                if(++count == 5){
                    count = 0;
                    System.out.println();
                }
            }
        }
        System.out.println("\n");
    }

    public static void printPrimeFactors(int num){
        int numO = num;
        Integer[] primeNumbers = devision.primeNumbersBelow(num).toArray(new Integer[0]);
        StringBuilder str = new StringBuilder();
        for(Integer i : primeNumbers){
            while (num % i == 0 && num > i){
                num /= i;
                str.append(i + "*");
            }
        }
        if(num != 1) str.append(num);
        else str.delete(str.length()-1, str.length()-1);
        System.out.println("Primfaktoren - von: " + numO+ "\n" + str.toString());
    }

    public static ArrayList<Integer> primeNumbersBelow(int num){
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i < num; i++){
            if(isPrime(i, i)){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static boolean isPrime(int num, int min){
        if(min == 1) return true;
        else if(num % min == 0 && num != min){
            return false;
        }
        else return isPrime(num, min - 1);
    }
}
