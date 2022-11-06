package Blatt4;

/**
 * Ceasar En/decrpytion
 *
 * @author Jakob Reichle
 */
public class encrypt {
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String text = "HPC SLE KFPCDE OLD CLPEDPW RPWZPDE - PC DNSCPTMP XTC MTEEP PTYP XLTW";

    public static void main(String[] args){
        for(int i = 1; i < 25; i++){
            System.out.println(i + "\t" + decryptText(text, i)+"\n");
        }
    }

    public static char crypt(char c, int n){
        if(alphabet.indexOf(c) == -1){
            return c;
        }
        int start = alphabet.indexOf(c);
        if(start + n > alphabet.length()) start -= 26;
        return alphabet.charAt(start + n);
    }

    public static char decrypt(char c, int n){
        if(alphabet.indexOf(c) == -1){
            return c;
        }
        int start = alphabet.indexOf(c);
        if(start - n < 0) start += 26;
        return alphabet.charAt((start - n));
    }


    public static String cryptText(String s, int n){
        s = s.toLowerCase();
        String[] words = s.split(" ");
        String newSentence = "";
        for(String word : words){
            for(char letter : word.toCharArray()){
                newSentence = newSentence + crypt(letter, n);
            }
            newSentence += " ";
        }
        return newSentence;
    }


    public static String decryptText(String s, int n){
        s = s.toLowerCase();
        String[] words = s.split("[ ]");
        String newSentence = "";
        for(String word : words){
            for(char letter : word.toCharArray()){
                newSentence = newSentence + decrypt(letter, n);
            }
            newSentence += " ";
        }
        return newSentence;
    }

}
