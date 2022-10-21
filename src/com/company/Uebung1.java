package com.company;

public class Uebung1 {

    static String SPACE = " ";
    static String STAR = "*";

    public static void main(String[] args){
        printStar();
    }

    static void printStar(){
        System.out.println(SPACE + STAR + repeatChar(SPACE, 5) + STAR + SPACE);
        System.out.println(repeatChar(SPACE, 2) + STAR + repeatChar(SPACE, 3) + STAR + repeatChar(SPACE, 2));
        System.out.println(repeatChar(SPACE, 3) + STAR + SPACE + STAR + repeatChar(SPACE, 3));
        System.out.println(repeatChar(STAR, 9));
        System.out.println(repeatChar(SPACE, 3) + STAR + SPACE + STAR + repeatChar(SPACE, 3));
        System.out.println(repeatChar(SPACE, 2) + STAR + repeatChar(SPACE, 3) + STAR + repeatChar(SPACE, 2));
        System.out.println(SPACE + STAR + repeatChar(SPACE, 5) + STAR + SPACE);
    }

    static String repeatChar(String character, int amount){
        String newString = "";
        for(int i = 0; i < amount; i++){
            newString = newString + character;
        }
        return newString;
    }
}
