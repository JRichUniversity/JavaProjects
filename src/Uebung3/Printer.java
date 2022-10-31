package Uebung3;

public class Printer {
    static final String STAR = "*";

    static final String SPACE = " ";

    public static void print(String str){
        System.out.print(str);
    }

    public static void println(String str){
        System.out.println(str);
    }

    public static String repeatChar(String str, int num){
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

    public static void paintStarBlanksStar(int offset, int num){
        println(repeatChar(SPACE, offset) + STAR + repeatChar(SPACE, num) + STAR);
    }

    public static void paintStars(int offset, int num){
        print(repeatChar(SPACE, offset));
        println(repeatChar(STAR, num));
    }
}
