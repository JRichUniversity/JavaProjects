package Blatt4;

public class primenumbers {
    public static void main(String[] args){ primeNum();}

    public static void primeNum(){
        int counter = 0;
        int primeNumbers = 0;
        for(int i = 2; i <= 1000; i++){
            if(isPrime(i, i)){
                System.out.print(i + "\t");
                counter++;
                primeNumbers++;
            }
            if(counter == 5){
                System.out.println();
                counter = 0;
            }
        }
        System.out.println("\n\nAnzahl der Primzahlen: " + primeNumbers);
    }

    public static boolean isPrime(int num, int lower){
        if(lower == 1) return true;
        else if(num % lower == 0 && num != lower){
            return false;
        }
        else return isPrime(num, lower - 1);
    }
}
