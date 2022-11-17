package Blatt5;
import java.util.HashMap;

import static jsTools.Input.*;

public class Substituition {
    static String[] encryptionTable;
    static String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static char[] charAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    static String commonCharacters = "ENISRATDHULCGMOBWFKZPVJYXQ";

    public static void main(String[] args){
        /*
        encryptionTable = readFile("src/Blatt5/Substitution.tab");
        String[] text = readFile("src/Blatt5/Geheim.txt");

        String[] newText = decryptText(text);
        for(String str : newText){
            System.out.println(str);
        }
         */
        testJuliya();
    }

    public static void testJuliya(){
        String path = readString("Bitte gib den Pfad der Datei an: ");
        String[] text = readFile(path);
        System.out.println("Bitte wähle aus was du machen möchtest:\n1.) Text verschlüsseln\n2.) Text entschlüsseln");
        int a = readInt("Bitte gib deine gewünschte Auswahlmöglichkeit ein: ");
        String key = readString("Bitte gib den Schlüssel zum ver-/entschlüsseln ein: ");
        while(key.toCharArray().length != 26){
            System.out.println("\nFEHLER: Schlüssel hat nicht die richtige länge!");
            key = readString("Bitte gib den Schlüssel zum ver-/entschlüsseln ein: ");
        }
        encryptionTable = new String[2];
        encryptionTable[0] = Alphabet;
        encryptionTable[1] = key;
        switch (a){
            case 1:
                text = cryptText(readFile(path));
                for(String str : text){
                    System.out.println(str);
                }
                break;
            case 2:
                text = decryptText(readFile(path));
                for(String str : text){
                    System.out.println(str);
                }
                break;
        }
    }

    /**
     * Encrypts a given char if char is contained in key
     * @param c Char to be decrypted
     * @return Decrypted char
     */
    public static char crypt(char c){
        c = charToUpper(c); //Umwandlung in Großbuchstaben
        if(encryptionTable[0].indexOf(c) != -1){
            return encryptionTable[1].charAt(encryptionTable[0].indexOf(c));
        } else return c;
    }

    /**
     * Decrypts a given char if char is contained in key
     * @param c Char to be decrypted
     * @return Decrypted char
     */
    public static char decrypt(char c){
        c = charToUpper(c);
        int pos = encryptionTable[1].indexOf(c);
        if(pos != -1){
            return encryptionTable[0].charAt(pos);
        } else return c;
    }

    /**
     * Encrypts a given text
     * @param txt Text to be decrypted
     * @return Decrypted text
     */
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

    /**
     * Decrypts a given text
     * @param txt Text to be decrypted
     * @return Decrypted text
     */
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

    /**
     * Transforms a char to upper case
     * @param c Char to be transformed
     * @return Char in its uppercase
     */
    public static char charToUpper(char c){
        StringBuilder str = new StringBuilder();
        str.append(c);
        return str.toString().toUpperCase().charAt(0);
    }

    /**
     * Opens and reads a file
     * @param path Path of the file to be read
     * @return Array of each line contained in the text
     */
    public static String[] readFile(String path){
        int size = getFileSize(path);
        fileReadOpen(path);
        String[] text = new String[size];
        for(int i = 0; i < size; i++){
            text[i] =  fileReadLine();
        }
        return text;
    }

    /**
     * Gives back the amount of lines in a given document
     * @param path Path to be opened and read
     * @return Amount of lines in document
     */
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

    //Generating and decrypting key


    /**
     * Converts key which matched with most common characters to a format like:
     * "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
     * "QWERTZUIOPASDFGHJKLMNBVCXY"
     * @param transform Gernerated Key
     * @param order Most common chars
     * @return Sorted Key
     */
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

    /**
     * Sorts the int[] with most chars from most to the least chars
     * @param array Array with the values of the counted chars for each letter
     * @return Sorted Key with the most used letter first and the least used letter last
     */
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

    /**
     * Counts the amount of chars for each letter.
     * @param path Path of the file
     * @return Array with the amount of chars for each letter arr[2]==5 => C:5
     */
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

    /**
     * Gives back the amount of times a char is used in a String
     * @param txt String to check
     * @param c Char to count
     * @return Amount of times the char is used in the String
     */
    public static int charCount(String txt, char c) {
        int count = 0;
        for(char m : txt.toCharArray()){
            if((int)c == (int)m) count++;
        }
        return count;
    }

    /**
     * Returns the position of a char in a given String
     * @param c Char to be checked
     * @return Postion of given char
     */
    public static int returnCharPos(char c){
        StringBuilder str = new StringBuilder();
        str.append(c);
        c = str.toString().toUpperCase().charAt(0);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(c);
    }

    /**
     * Creates an empty int[size] array with default values 0
     * @param size Size of the array
     * @return Array with default values 0 and given size
     */
    public static int[] emptyArray(int size){
        int[] arr = new int[size];
        for(int i : arr){
            i = 0;
        }
        return arr;
    }

    /**
     * Prints a given int[] array
     * @param arr Array to be printed in console
     */
    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
