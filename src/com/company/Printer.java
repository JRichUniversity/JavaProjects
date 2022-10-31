package com.company;

public class Printer {

    static final String STAR = "*";

    static final String SPACE = " ";

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

    private static void paintStars(int offset, int num){
        print(repeatChar(SPACE, offset));
        println(repeatChar(STAR, num));
    }

    private static void paintStarBlanksStar(int offset, int num){
        println(repeatChar(SPACE, offset) + STAR + repeatChar(SPACE, num) + STAR);
    }

    public static void drawFilledTriangle(int height){
        drawTriangle(height, 1);
    }

    public static void drawEmptyTriangle(int height){
        drawTriangle(height, 2);
    }

    private static void drawTriangle(int height, int mode){
        int width = height * 2 - 1;
        int firstIndent = (width - 1) / 2;
        switch (mode) {
            case 1 -> {
                for (int i = 0; i < height; i++){
                    paintStars(firstIndent - i, 1 + i * 2);
                }
            }
            case 2 -> {
                for (int i = 0; i < height; i++){
                    if(i==0) paintStars(firstIndent, 1);
                    else if (i == height - 1) paintStars(0, width);
                    else {
                        paintStarBlanksStar(firstIndent - i, width - 2 - (2 * (firstIndent - i)));
                    }
                }
            }
            default -> println("No such input Method");
        }
    }
}
