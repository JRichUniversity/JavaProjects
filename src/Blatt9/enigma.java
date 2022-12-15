package Blatt9;

public class enigma {
    static String key1 = "E K M F L G D Q V Z N T O W Y H X U S P A I B R C J";
    static String key2 = "K M F L G D Q V Z N T O W Y H X U S P A I B R C J E";
    static String key3  = "M F L G D Q V Z N T O W Y H X U S P A I B R C J E K";

    static walze[] walzen = new walze[3];

    static int indexWalze = 0;

    public static void main(String[] args){
        walzen[0] = new walze(key1, 22);
        walzen[1] = new walze(key2, 0);
        walzen[2] = new walze(key3, 0);
        cryptString();
    }

    static void cryptString(){
        String hi = "HelloHelloHelloHello";
        hi.toUpperCase();
        String en = "";
        for(char c : hi.toCharArray()){
            en += crypt(c);
        }
        System.out.println(en);
    }

    static char crypt(char c){
        char encrypt = walzen[indexWalze].getNextKey();
        while(encrypt == '-'){
            if(indexWalze < walzen.length-1){
                indexWalze++;
            } else indexWalze = 0;
            encrypt = walzen[indexWalze].getNextKey();
        }
        return encrypt;
    }
}
