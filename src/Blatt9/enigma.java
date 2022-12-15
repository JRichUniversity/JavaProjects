package Blatt9;

public class enigma {

    walze[] arr = new walze[3];
    walze n = new walze("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
    public static void main(String[] args){
        System.out.println(convert("Hallo mein name ist, Chalacka!"));
    }

    static String convert(String txt){
        txt = txt.toLowerCase();
        StringBuilder s = new StringBuilder();
        char[] line = txt.toCharArray();
        for(int i = 0; i < line.length; i++){
            if((int)line[i] == (int)'?' || (int)line[i] == (int)'.' || (int)line[i] == (int)'!'  || (int)line[i] == (int)','){
                s.append('X');
            }
            else if(i < line.length-1 && line[i] == 'c' && (line[i + 1] == 'k' || line[i + 1] == 'h')){
                s.append('Q');

            }else if(line[i] >= 97 && line[i] <= 122){
                s.append(line[i]);
            }
        }
        return s.toString();
    }
}
