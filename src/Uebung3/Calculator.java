package Uebung3;

public class Calculator {

    static Printer printer = new Printer();

    public static int pow(int x, int y){
        return (int)Math.pow(x, y);
    }

    public static void calcAndPrint(int a, int b){
        Printer.println("Sum = " + sum(a, b));
        Printer.println("Difference = " + difference(a, b));
        Printer.println("Product = " + product(a, b));
        Printer.println("Quotient = " + quotient(a, b));
    }

    private static int sum(int a, int b){
        return a + b;
    }

    private static int difference(int a, int b){
        return a - b;
    }

    private static int product(int a, int b){
        return a * b;
    }

    private static double quotient(int a, int b){
        if(checkDivision(b)) {
            return (double)a/(double)b;
        }
        else return 9999999;
    }

    private static boolean checkDivision(int x){
        return x != 0;
    }

    private static void paintStars(int offset, int num){
        Printer.print(Printer.repeatChar(Printer.SPACE, offset));
        Printer.println(Printer.repeatChar(Printer.STAR, num));
    }
}
