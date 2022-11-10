package Blatt4P;
import static jsTools.Graph.*;


public class Squares {

    public static void main(String[] args){
        film();
    }

    static boolean ueberlappung(int xR1, int bR1, int yR1, int hR1, int xR2, int bR2, int yR2, int hR2){
        int top = yR2;
        int bot = yR2 + hR2;
        int left = xR2;
        int right = xR2 + bR2;

        int topTest = yR1;
        int botTest = yR1 + hR1;
        int leftTest = xR1;
        int rightTest = xR1 + bR1;

        //System.out.println("Top: " + top + " Bottom: " + bot);
        //System.out.println("TopB: " + topTest + " BottomB: " + botTest);


        // )
        if((isBetween(bot, topTest, botTest) || isBetween(top, topTest, botTest)) && (isBetween(left, leftTest, rightTest) || isBetween(right, leftTest, rightTest))){
            return true;
        }
        else if(hR2 >= hR1){
            if((isBetween(topTest, top, bot) && isBetween(botTest, top, bot)) && (isBetween(left, leftTest, rightTest) || isBetween(right, leftTest, rightTest))){
                return true;
            }
            else return false;
        }
        else return false;
    }

    static boolean isBetween(int val, int min, int max){
        if(val > min && val < max){
            return true;
        } else return false;
    }

    public static void film(){
        int xR1=200;
        int yR1=190;
        int bR1=100;
        int hR1=150;
        addRect ( xR1 , yR1 , bR1 , hR1 ,"blue");

        moveRechteck( xR1 , bR1, yR1, hR1, 80 , 100);
        moveRechteck( xR1 , bR1 , yR1 , hR1, 160 , 100);
        moveRechteck( xR1 , bR1 , yR1 , hR1, 80 , 180);
        moveRechteck( xR1 , bR1 , yR1 , hR1, 160 , 180);
    }

    public static void moveRechteck(int xR1, int bR1, int yR1, int hR1, int b, int h){
        int r = addRect(40,0, b,h,"green");
        for(int y = 10; y < 400;y += 10){
            for(int x = 10; x < 400;x += 10 ){
                if(ueberlappung(xR1, bR1, yR1, hR1, x, b, y, h)){
                    setColor(r, "red");
                }
                else {
                    setColor(r, "green");
                }
                setPos(r, x, y);
                paintNew();
                sleep(5);
            }
        }
    }
}
