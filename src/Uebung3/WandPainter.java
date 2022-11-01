package Uebung3;
import jsTools.Wand;

import static jsTools.Wand.*;
import java.util.Random;

public class WandPainter {

    Wand wand = new Wand();
    static final int SPEED = 100;
    static String color = "black";

    public static void main(String[] args){
        initWand();
    }

    public static boolean paintHor(int x, int y, int len){
        if(len > 0){
            paint(x, y);
            return paintHor(x + 1, y, len - 1);
        }
        else return true;
    }

    public static boolean paintVer(int x, int y, int len){
        if(len > 0){
            paint(x, y);
            return paintVer(x, y + 1, len - 1);
        }
        else return true;
    }

    public static boolean paintDia(int x, int y, int len){
        if(len > 0){
            paint(x, y);
            return paintDia(x + 1, y + 1, len - 1);
        }
        else return true;
    }

    public static boolean paintCounterDia(int x, int y, int len){
        if(len > 0){
            paint(x, y);
            return paintCounterDia(x + 1, y - 1, len - 1);
        }
        else return true;
    }

    public static void paintSquare(int startX, int startY, int dimX, int dimY){
        paintHor(startX, startY, dimX);
        paintHor(startX, startY + dimY - 1, dimX);
        paintVer(startX, startY, dimY);
        paintVer(startX + dimX - 1, startY, dimY);
    }

    public static void paintCross(int x, int y, int size){
        if(isEven(size)){
            size++;
        }
        int offset = (size-1)/2;
        paintDia(x - offset, y - offset, size);
        paintCounterDia(x - offset, y + offset, size);
    }

    public static void paintDiamond(int x, int y, int size){
        if(isEven(size)) size++;
        int width = size * 2 - 1;
        int offset = (width-1)/2;
        paintDia(x - offset, y, size);
        paintDia(x, y - offset, size);
        paintCounterDia(x - offset, y, size);
        paintCounterDia(x, y + offset, size);
    }


    public static void changeColor(String newCol){
        color = newCol;
    }

    public static void randomColor(){
        Random random = new Random();
        int random_num = random.nextInt(0xffffff + 1);
        String random_color = String.format("#%06x", random_num);
        color = random_color;
    }

    public static boolean check(int num){
        if(num < 1 || num > 24){
            return false;
        }
        else return true;
    }

    public static boolean isEven(int num){
        return num%2 == 0;
    }

    private static void paint(int x, int y){
        if(check(x) && check(y)){
            randomColor();
            setWandColor(y - 1, x - 1, color);
            paintWandNew();
            sleep(SPEED);
        }
    }
}
