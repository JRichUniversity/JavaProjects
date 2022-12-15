package Blatt9;

public class walze {
    final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String index;
    String key;
    static int walzen = 0;

    walze(String index, walze vorgänger){
        this.index = index;
        this.key = vorgänger.getKey();
    }

    walze(String key){
        if(walzen == 0){
            this.index = ALPHABET;
        }
        this.key = key;
    }

    char crypt(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
        {
            if(c >= 'a' && c <= 'z'){
                c = (char)('A'+(c-'a'));
            }
            return key.charAt(index.indexOf(c));
        }
        return c;
    }

    String getKey(){
        return this.key;
    }
}
