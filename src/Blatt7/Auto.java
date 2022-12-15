package Blatt7;
import static jsTools.Input.*;

public class Auto {
    String hersteller;
    int posX;
    int posY;
    int kmStand;
    int baujahr;

    void init(String hst, int x, int y, int km, int bj){
        hersteller = hst;
        posX = x;
        posY = y;
        kmStand = km;
        baujahr = bj;
    }

    void readValues(){
        hersteller = readLine("Hersteller: ");
        posX = readInt("PosX: ");
        posY = readInt("PosY: ");
        kmStand = readInt("KmS-Stand: ");
        baujahr = readInt("Baujahr: ");
    }

    void driveTo(int newX, int newY){
        double dis = Math.sqrt((newY - posY) * (newY - posY) + (newX - posX) * (newX - posX));
        kmStand += dis;
        System.out.println("Gefahrene Distanz: " + (int)dis + " Km");
        posX = newX;
        posY = newY;
    }

    void print(){
        System.out.println("Hersteller: " + hersteller + " posX: " + posX + " posY: " + posY + " Km-Stand: " + kmStand + " Baujahr: " + baujahr);
    }
}
