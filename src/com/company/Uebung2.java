package com.company;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
import static jsTools.Input.*;

/**
 * Uebung2.java
 *
 * @author Jakob Reichle
 */
public class Uebung2 {

    /**
     * Solutions for the programming I internship.
     */

    static String[] DAYS = {"Sunday", "Monday", "Thursday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static Map<String, Integer> DICTIONARY = new HashMap<>(){{ //HashMap dictionary for matching months with their corresponding numbers.
        put("January", 13);
        put("February", 14);
        put("March", 3);
        put("April", 4);
        put("May", 5);
        put("June", 6);
        put("July", 7);
        put("August", 8);
        put("September", 9);
        put("October", 10);
        put("November", 11);
        put("December", 12);
    }};

    static String STAR = "*";
    static String SPACE = " ";

    public static void main(String[] args){
        start();
    }

    /**
     * Method used for initialising and restarting the selection menu
     */
    public static void start(){
        System.out.println("What action would you like to perform?\n\n1 - Weekday calculation\n2 - Faculty of a given number\n3 - Table of square numbers\n4 - Draw a form\n5 - Multiplication Table\n6 - Checksum\n7 - Exit\n");
        handler(readInt("Please enter a value: "));
    }

    /**
     * Menu for handling all program operations
     */
    public static void handler(int var) {
        System.out.println();
        switch (var) {
            case 1 -> {
                System.out.println("Please choose a date with the following format - DD.Month YYYY");
                String DATE = readLine("Please enter a date: ");
                if (isValid(DATE)) {
                    dayOfTheWeek(convertDays(DATE));
                } else {
                    System.out.println("Illegal format of date.");
                }
                exitCase();
            }
            case 2 -> {
                int x = readInt("Please enter a Number: ");
                System.out.println("\n!" + x + " = " + faculty(x));
                exitCase();
            }
            case 3 -> {
                squareNumbers();
                exitCase();
            }
            case 4 -> {
                printForm();
                exitCase();
            }
            case 5 -> {
                multiplications();
                exitCase();
            }
            case 6 -> {
                int x = readInt("Please enter a number to checksum: ");
                System.out.println();
                checkSum(x);
                exitCase();
            }
            case 7 -> {
                String next = readLine("\nWould you like to continue? (y/n): ");
                if (next.equals("y")) {
                    start();
                } else {
                    System.out.println("Goodbye!");
                }
            }
            default -> System.out.println("Error");
        }
    }

    public static void exitCase(){
        handler(7);
    }

    /**
     * Calculates the given weekday of a date
     * @param format Integer array in the form of [day, month, year, century]
     */
    public static void dayOfTheWeek(int[] format){
        int w = (format[0] + ((26*(format[1] + 1)) / 10) + ((5 * format[2]) / 4) + (format[3] / 4) + (5 * format[3]) - 1) % 7;
        System.out.println(DAYS[w]);
    }

    /**
     * Converts a given String to a usable date-array
     * E.g.: "24.December 2025" -> [24, 12, 25, 20]
     * @param date String of given date
     * @return Array of date, month, year, century
     */
    public static int[] convertDays(String date){
            String[] result = date.split("[. ]");
            String[] cent = result[2].split("(?<=\\G.{2})");
            int month = DICTIONARY.get(result[1]), day = Integer.parseInt(result[0]), century = Integer.parseInt(cent[0]), year = Integer.parseInt(cent[1]);
            if(month == 13 || month == 14){
                year--;
            }
        return new int[]{day, month, year, century};
    }

    /**
     * Checks a given String to be accepted as a usable date
     * @param str String of the date in the format of "DD.MonthInWords YYYY"
     * @return Returns if a given String is usable
     */
    public static boolean isValid(String str){
        String[] result = str.split("[. ]");
        String re = "\\d+.\\w+\\s\\d{4}";
        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(str);
        return mt.matches() && (DICTIONARY.get(result[1]) != null);
    }

    /**
     * Methode to receive the faculty of a given number
     * @param number Number to get the faculty from
     */
    public static int faculty(int number){
        if(number >= 1){
            return number * faculty(number - 1);
        }
        else {
            return 1;
        }
    }

    /**
     * Method for tabulating squared numbers
     */
    public static void squareNumbers(){
        int length = readInt("\nPlease enter the length of the list: ");
        System.out.println("\nNumber\tSquared\tSumOfNumbers\tSumOfSquaredNumbers");
        int sumOfNumbers = 0;
        int sumOfSquared = 0;
        for(int i = 1; i <= length; i++){
            sumOfNumbers = sumOfNumbers + i;
            sumOfSquared = sumOfSquared + (i * i) ;
            System.out.println(i + "\t\t" + (i * i) + "\t\t" + sumOfNumbers + "\t\t\t\t" + sumOfSquared);
        }
    }

    /**
     * Selection menu for drawing a predefined shape in the console
     */
    public static void printForm(){
        System.out.println("Please choose one of the following forms:\n\n1 - Square\n2 - Triangle\n3 - Rotated Square");
        int mode = readInt("\nPlease select a form: ");
        int[] sizes = chooseMethod(mode);
        int x = sizes[0];
        int y = sizes[1];
        if(x < 2 || y < 2){
            System.out.println("Shape not big enough to be drawn");
            return;
        }
        System.out.println();
        switch (mode) {
            case 1 -> drawSquare(x, y);
            case 2 -> drawTriangle(y);
            case 3 -> drawTurnedSquare(x);
            default -> System.out.println("Unknown shape ID");
        }

    }

    /**
     * Submenu for selecting dimensions of different drawing operation
     * @param method Chosen method of drawing
     * @return Returns starting dimensions for each possible selection
     */
    public static int[] chooseMethod(int method){
        System.out.println();
        int[] answer = new int[2];
        switch (method) {
            case 1 -> {
                String size = readLine("Please enter the size of the square (x,y): ");
                String[] result = size.split(",");
                answer[0] = Integer.parseInt(result[0]);
                answer[1] = Integer.parseInt(result[1]);
            }
            case 2 -> {
                String sizeTriangle = readLine("Please enter the height of the triangle: ");
                String[] resultTriangle = sizeTriangle.split(",");
                answer[0] = Integer.parseInt(resultTriangle[0]);
                answer[1] = Integer.parseInt(resultTriangle[0]);
            }
            case 3 -> {
                String sizeRotatedSquare = readLine("Please enter the height of the square: ");
                String[] resultRotated = sizeRotatedSquare.split(",");
                answer[0] = Integer.parseInt(resultRotated[0]);
                answer[1] = Integer.parseInt(resultRotated[0]);
            }
            default -> System.out.println("Invalid action");
        }
        return answer;
    }

    /**
     * Draws a turned square in the console
     * @param s Size of the turned square
     */
    public static void drawTurnedSquare(int s){
        int height = s - 1;
        int width = s * 2 - 1;
        for(int i = -height; i <= height; i++) {
            if (Math.abs(i) == height) {
                System.out.println(multiplyChar(SPACE, Math.abs(i)) + STAR);
            } else if (i == 0) {
                System.out.println(multiplyChar(SPACE, 0) + STAR + "\t" + multiplyChar(SPACE, width-2) +  STAR);
            }
            else {
                System.out.println(multiplyChar(SPACE, Math.abs(i)) + STAR + "\t" + multiplyChar(SPACE, width - (2 + 2 * Math.abs(i))) +  STAR);
            }
        }
    }

    /**
     * Method for drawing a triangle in the console
     * @param relativeY relative height of the triangle
     */
    public static void drawTriangle(int relativeY){
        int x = (2*relativeY)-1;
        for(int i = 1; i <= relativeY; i++){
            if(i == 1){
                System.out.println(multiplyChar(SPACE, relativeY - i) + STAR);
            } else if (i == relativeY){
                System.out.println(multiplyChar(STAR, x));
            }
            else{
                System.out.println(multiplyChar(SPACE, relativeY - i) + STAR + "\t" + multiplyChar(SPACE, x - 2 - (2 * (relativeY - i))) + STAR);
            }
        }
    }

    /**
     * Method for drawing a square in the console
     * @param x x dimension of the square
     * @param y y dimension of the square
     */
    public static void drawSquare(int x, int y){
        for(int i = 1; i <= y; i++) {
            if (i == 1 || i == y) {
                System.out.println(multiplyChar(STAR, x));
            } else {
                System.out.println(STAR + multiplyChar(SPACE, x - 1) + STAR);
            }
        }
    }

    /**
     * Multiplies a certain amount of times Char and returns a combined String
     * Example: "_" * 5 => "_____"
     * @param str Char to be multiplied
     * @param num Amount of times to be multiplied
     * @return Combined String
     */
    public static String multiplyChar(String str, int num){
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < num; i++){
            newStr.append(str).append("\t");
        }
        return newStr.toString();
    }

    /**
     * Method used to create a multiplications table
     */
    public static void multiplications(){
        int x = readInt("Enter table dimension: ");
        System.out.println();
        printHeader(x);
        for(int i = 1; i <= x; i++){
            int[] arr = new int[x+1];
            arr[0] = i;
            for(int j = 1; j <= x; j++){
                arr[j] = i * j;
            }
            printLine(arr);
        }
        printClosing(x);
    }

    /**
     * Prints the header element for a table
     * @param x The amount of elements included in a header
     */
    public static void printHeader(int x){
        System.out.print("----|");
        for(int i = 1; i <= x; i++){
            System.out.print("----");
        }
        System.out.print("----|\n\t|\t");
        for(int i = 1; i <= x; i++){
            System.out.print(i + "\t");
        }
        System.out.print(" |\n----|");
        for(int i = 1; i <= x; i++){
            System.out.print("----");
        }
        System.out.print("----|");
    }

    /**
     * Prints a formatted line for a table
     * @param vars list of all numbers that will be printed and their iteration index
     */
    public static void printLine(int[] vars){
        System.out.print("\n" + vars[0]);
        if(vars[0] > 9){
            System.out.print("  |\t");
        }
        else{
            System.out.print("   |\t");
        }
        for(int x = 1; x < vars.length; x++){
            System.out.print(vars[x] + "\t");
        }
        System.out.print(" |");
    }

    /**
     * Prints the closing element of a table
     * @param x the amount of elements printed in the table
     */
    public static void printClosing(int x){
        System.out.print("\n----|");
        for(int i = 1; i <= x; i++){
            System.out.print("----");
        }
        System.out.print("----|");
    }

    /**
     * Method used to receive the checksum of a given number (1234 -> 10)
     * @param num number to get the checksum of
     */
    public static void checkSum(int num){
        String str = String.valueOf(num);
        int sum = 0;
        for(int j = 0; j < str.length(); j++){
            int n = Integer.parseInt(Character.toString(str.charAt(j)));
            sum = sum + n;
        }
        System.out.println("Checksum = " + sum);
    }
}
