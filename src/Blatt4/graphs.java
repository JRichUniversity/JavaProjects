package Blatt4;
import javax.sound.midi.SysexMessage;
import java.util.Random;

import static jsTools.Graph.*;

public class graphs {

    static int dirX = randomNumber();
    static int dirY = randomNumber();
    static int[] bounds = {35, 690};
    static int radius = 30;

    public static void main(String[] args){
        int px = 10;
        int py = 500;
        addRect(10, 10, 680, 680, "black");
        int circle = addCircleBorder(px + 10, py , radius, "blue");
        pong(circle, px + 10, py);
        for(int i = 0; i < 10; i++){
            System.out.println(newRandomNum(1));
        }
    }

    public static void runningBallFor(int form, int startX, int startY){
        for(int i = 0; i < 500; i++){
            moveElement(form, startX, startY);
            startX = startX + 2;
            sleep(20);
        }
    }

    public static void runningBallWhile(int form, int startX, int startY, int max){
        while(startX < max){
            moveElement(form, startX, startY);
            startX = startX + 2;
            sleep(20);
        }
    }

    public static void pong(int form, int startX, int startY){
        while(inBounds(startX + radius) && inBounds(startY + radius)){
            int nextX = startX + radius + dirX;
            int nextY = startY + radius + dirY;
            if(!inBounds(nextX)) dirX = newRandomNum(dirX) * -1;
            else if(!inBounds(nextY)) dirY = newRandomNum(dirY) * -1;
            moveElement(form, startX + dirX, startY + dirY);
            sleep(5);
            startX += dirX;
            startY += dirY;
        }
    }

    public static boolean inBounds(int pos){
        if(pos > bounds[0] && pos < bounds[1]) return true;
        else return false;
    }

    public static int randomNumber(){
        int num = -1 + (int)(Math.random() * ((1 + 1) + 1));
        System.out.println(num);
        if(num != 0) return num;
        else return 1;
    }

    public static int newRandomNum(int num){
        Random ran = new Random();
        int var = ran.nextInt(3);
        if(var == 0) var = 1;
        if(num > 0) return var;
        else return var * -1;
    }

    public static void moveElement(int elNum, int toX, int toY) {
        setPos(elNum, toX, toY);
        paintNew();
    }
}
