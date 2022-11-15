package Blatt5;
import static jsTools.Graph.*;

public class chess {
    final static int SQUARE_SIZE = 40;


    public static void main(String[] args){
        drawField(20,20);
    }

    public static void drawField(int sizeX, int sizeY){
        addRect(0,0,sizeX*SQUARE_SIZE+5, sizeY*SQUARE_SIZE+5, "grey");
        boolean firstBlack = true;
        for(int i = 0; i < sizeY; i++){
            printRow(firstBlack, sizeX, i*40);
            firstBlack = !firstBlack;
        }
    }

    public static void printRow(boolean firstBlack, int len, int posY){
        for(int i = 0; i < len; i++){
            if(firstBlack){
                addRect(i*40, posY, SQUARE_SIZE, SQUARE_SIZE, "black");
            } else addRect(i*40, posY, SQUARE_SIZE, SQUARE_SIZE, "white");
            firstBlack = !firstBlack;
        }
    }
}
