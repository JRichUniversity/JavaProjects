package com.company;

public class Printer {

    private static void print(String str){
        System.out.print(str);
    }

    private static void println(String str){
        System.out.println(str);
    }

    private static String repeatChar(String str, int num){
        return String.valueOf(str).repeat(num);
    }

    public static void onlyPrinting(){
        println("Bla");
    }

    public static void printText(String str, int num){
        print(repeatChar(str, num));
    }

    public static void printWithIndentedStars(int indent, int count){
        printText(" ", indent);
        printText("*", count);
    }

    public static void printlnWithIndentedStars(int indent, int count){
        printWithIndentedStars(indent, count);
        println("\n");
    }

    public static String genLineWithIndentedStars(int indent, int count){
        return repeatChar(" ", indent) + repeatChar("*", count);
    }

    public static int pow(int x, int y){
        return (int)Math.pow(x, y);
    }

    public static void calcAndPrint(int a, int b){
        println("Sum" + sum(a, b));
        println("Difference = " + difference(a, b));
        println("Product = " + product(a, b));
        println("Quotient = " + quotient(a, b));
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

    private static int quotient(int a, int b){
        if(checkDivision(b)) return a/b;
        else return 9999999;
    }

    private static boolean checkDivision(int x){
        return x != 0;
    }
}
