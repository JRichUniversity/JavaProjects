package Blatt4P;

public class CountingNumbers {
    //Git
    public static void main(String[] args){
        System.out.println("Zahlen ausgegeben: " + count(5, 100, 6));
    }

    public static int count(int start, int end, int dif){
        int count = 0;
        for(int i = start; i < end; i += dif){
            if(i != start){
                System.out.println(i + "\t");
                count++;
            }
        }
        return count;
    }
}
