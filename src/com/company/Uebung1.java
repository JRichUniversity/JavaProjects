package com.company;

public class Uebung1 {

    static String SPACE = " ";
    static String STAR = "*";
    static int SIZE = 3;
    static int WIDTH = 9;

    public static void main(String[] args){
        printStar();
    }

    static void printStar(){
        for(int i = -SIZE; i <= SIZE;i++){
            if(i == 0){
                System.out.println(repeatChar(STAR, WIDTH));
            } else {
                System.out.println(repeatChar(SPACE, SIZE - Math.abs(i) + 1) + STAR + repeatChar(SPACE, WIDTH - 2 - (2 * (SIZE - Math.abs(i) + 1))) + STAR);
            }
        }
    }

    static String repeatChar(String str, int var){
        return String.valueOf(str).repeat(var);
    }
}
