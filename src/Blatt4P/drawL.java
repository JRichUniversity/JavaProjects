package Blatt4P;

public class drawL {
    //Git
    public static void main(String[] args){
        printL(4, 5, 3);
        System.out.println("123456789");
        //test();
    }

    public static void printL(int indent, int h, int l){
        for(int i = 1; i < h; i++){
            System.out.print(repeatChar(" ", indent) + "*\n");
        }
        System.out.println(repeatChar(" ", indent) + repeatChar("*", l));
    }

    public static String repeatChar(String str, int num){
        return str.repeat(num);
    }
}
