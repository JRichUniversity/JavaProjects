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
        String str = cryptString("Hello Gecko Morecho!?");
    }

    static String[] cryptText(String[] txt){
        String[] result = new String[txt.length];
        for(int i = 0; i < txt.length;i++){
            result[i] = cryptString(txt[i]);
        }
        return result;
    }

    static String cryptString(String str){
        String txt = str;
        txt = txt.toUpperCase();
        txt = replace(txt);
        System.out.println(txt);
        StringBuilder result = new StringBuilder();
        char[] chars = txt.toCharArray();
        for(char c : chars){
            if(c >= 'A' && c <= 'Z'){
                result.append(crypt(c));
            }
            else if (c == '!' || c == '.' || c == ',' || c == '?'){
                result.append('X');
            }
        }
        return result.toString();
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

    static String replace(String str){
        String new_str = "";
        for(int i = 0; i < str.length();i++){
            if(i < str.length()-2){
                if(str.charAt(i) == 'C' && (str.charAt(i+1) == 'K' || str.charAt(i+1) == 'H')){
                    new_str += "Q";
                    i++;
                }
                else new_str += str.charAt(i);
            }
            else {
                new_str += str.charAt(i);
            }
        }
        return new_str;
    }
}
