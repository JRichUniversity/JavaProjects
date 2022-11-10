package Blatt4P;
import java.util.ArrayList;

public class primeDevision {
    //Git
    public static void main(String[] args){
        printPrimeFactors(9);
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


}
