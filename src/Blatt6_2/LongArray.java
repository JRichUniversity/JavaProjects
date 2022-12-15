package Blatt6_2;

public class LongArray {
    static int[][] arr = {{1,2, 3, 4},
                          {8, 5, 0,-3},
                          {2,-3, 23, 11}};

    public static void main(String[] args){
        findSmallest(arr);
    }

    public static int findSmallest(int[][] array){
        int smallest = 0;
        int posX = 0;
        int posY = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] < smallest){ //Falls letztes Element erwünscht ändere < zu <=
                    smallest = array[i][j];
                    posY = i;
                    posX = j;
                }
            }
        }
        System.out.println("Kleinste Zahl: " + smallest + " an Position [" + posY + "][" + posX + "]");
        return smallest;
    }
}
