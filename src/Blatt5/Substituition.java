package Blatt5;
import java.util.HashMap;

import static jsTools.Input.*;

public class Substituition {
    static String[] encryptionTable;
    static String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static char[] charAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    static String commonCharacters = "ENISRATDHULCGMOBWFKZPVJYXQ";

    public static void main(String[] args){
        encryptionTable = readFile("src/Blatt5/Substitution.tab");
        String[] text = readFile("src/Blatt5/Geheim.txt");

        String[] newText = decryptText(text);
        for(String str : newText){
            System.out.println(str);
        }
    }

    public static char crypt(char c){
        c = charToUpper(c);
        if(encryptionTable[0].indexOf(c) != -1){
            return encryptionTable[1].charAt(encryptionTable[0].indexOf(c));
        } else return c;
    }

    public static char decrypt(char c){
        c = charToUpper(c);
        int pos = encryptionTable[1].indexOf(c);
        if(pos != -1){
            return encryptionTable[0].charAt(pos);
        } else return c;
    }

    public static String[] cryptText(String[] txt){
        for(int i = 0;i < txt.length;i++){
            StringBuilder str = new StringBuilder();
            char[] c = txt[i].toCharArray();
            for(int j = 0; j < c.length;j++){
                str.append(crypt(c[j]));
            }
            txt[i] = str.toString();
        }
        return txt;
    }

    public static String[] decryptText(String[] txt){
        for(int i = 0;i < txt.length;i++){
            StringBuilder str = new StringBuilder();
            char[] c = txt[i].toCharArray();
            for(int j = 0; j < c.length;j++){
                str.append(decrypt(c[j]));
            }
            txt[i] = str.toString();
        }
        return txt;
    }

    public static char charToUpper(char c){
        StringBuilder str = new StringBuilder();
        str.append(c);
        return str.toString().toUpperCase().charAt(0);
    }

    public static String[] readFile(String path){
        int size = getFileSize(path);
        fileReadOpen(path);
        String[] text = new String[size];
        for(int i = 0; i < size; i++){
            text[i] =  fileReadLine();
        }
        return text;
    }

    private static int getFileSize(String path){
        fileReadOpen(path);
        int lineCount = 0;
        String ln = fileReadLine();
        while(ln != null){
            ln = fileReadLine();
            lineCount++;
        }
        return lineCount;
    }

    public static String finalKey(String transform, String order){
        StringBuilder str = new StringBuilder();
        char[] alphabet = Alphabet.toCharArray();
        char[] transformer = transform.toCharArray();
        for(int i = 0; i < alphabet.length; i++){
            int n = order.indexOf(alphabet[i]);
            str.append(transformer[n]);
        }
        return str.toString();
    }

    public static String genKey(int[] array) {
        char[] newAlphabet = charAlphabet;
        int tempInt;
        char tempChar;
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array.length - 1; y++) {
                if (array[y] < array[y + 1]) {
                    //Switch Ints
                    tempInt = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = tempInt;

                    //Switch Chars
                    tempChar = newAlphabet[y];
                    newAlphabet[y] = newAlphabet[y + 1];
                    newAlphabet[y + 1] = tempChar;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(newAlphabet);
        return str.toString();
    }

    public static int[] charsInText(String path){
        int[] arr = emptyArray(encryptionTable[0].length());
        String[] text = readFile(path);
        for(String s : text){
            s = s.toUpperCase();
            for(char c : charAlphabet){
                arr[returnCharPos(c)] += charCount(s, c);
            }
        }
        return arr;
    }

    public static int charCount(String txt, char c) {
        int count = 0;
        for(char m : txt.toCharArray()){
            if((int)c == (int)m) count++;
        }
        return count;
    }

    public static int returnCharPos(char c){
        StringBuilder str = new StringBuilder();
        str.append(c);
        c = str.toString().toUpperCase().charAt(0);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(c);
    }

    public static int[] emptyArray(int size){
        int[] arr = new int[size];
        for(int i : arr){
            i = 0;
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
