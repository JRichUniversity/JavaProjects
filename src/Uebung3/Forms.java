package Uebung3;

public class Forms {
    private static int getWidth(int size){ return size * 2 - 1; }

    private static int getIndent(int size){ return (getWidth(size) - 1) / 2; }

    public static void drawFilledTriangle(int height){ drawTriangle(height, 1); }

    public static void drawEmptyTriangle(int height){ drawTriangle(height, 2); }

    private static void drawTriangle(int height, int mode){
        int width = getWidth(height);
        int firstIndent = getIndent(height);
        switch (mode) {
            case 1 -> {
                for (int i = 0; i < height; i++){
                    Printer.paintStars(firstIndent - i, 1 + i * 2);
                }
            }
            case 2 -> {
                for (int i = 0; i < height; i++){
                    if(i==0) Printer.paintStars(firstIndent, 1);
                    else if (i == height - 1) Printer.paintStars(0, width);
                    else {
                        Printer.paintStarBlanksStar(firstIndent - i, width - 2 - (2 * (firstIndent - i)));
                    }
                }
            }
            default -> Printer.println("No such input Method");
        }
    }

    public static void drawFilledDiamond(int size){ drawDiamond(size, 1); }

    public static void drawEmptyDiamond(int size){ drawDiamond(size, 2); }

    private static void drawDiamond(int size, int mode){
        int height = size - 1;
        int width = getWidth(size);
        int firstIndent = getIndent(size);
        switch (mode) {
            case 1 -> {
                for(int i = -height, j = 0; i <= height; i++){
                    Printer.paintStars(Math.abs(i), 1 + j * 2);
                    if(i < 0) j++;
                    else j--;
                }
            }
            case 2 -> {
                for(int i = -height, j = 0; i <= height; i++){
                    if(Math.abs(i) == height){
                        Printer.paintStars(Math.abs(i), 1);
                    }
                    else{
                        Printer.paintStarBlanksStar(Math.abs(i), width - 2 - (2 * (firstIndent - j)));
                    }
                    if(i < 0) j++;
                    else j--;
                }

            }
            default -> Printer.print("No such method");
        }
    }

    public static void drawFilledSquare(int x, int y){ drawSquare(x, y, 1); }

    public static void drawEmptySquare(int x, int y){ drawSquare(x, y, 2); }

    private static void drawSquare(int x, int y, int mode){
        switch (mode) {
            case 1 -> {
                for(int i = 0; i < y; i++){
                    Printer.println(Printer.repeatChar(Printer.STAR, x));
                }
            }
            case 2 -> {
                for(int i = 0; i < y; i++){
                    if(i == 0 || i == y - 1) Printer.paintStars(0, x);
                    else Printer.paintStarBlanksStar(0, x-2);
                }
            }
            default -> {
                Printer.println("No such module");
            }
        }
    }
}
