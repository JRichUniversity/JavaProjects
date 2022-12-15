package Blatt9;

public class walze {
    String key;
    int counter = 0;

    walze(String key, int start){
        this.key = format(key);
        this.counter = start;
    }


    String format(String key){
        String[] str = key.split(" ");
        String new_str = "";
        for(String s : str){
            new_str += s;
        }
        return new_str;
    }

    char getNextKey(){
        if(counter < key.length()) return key.charAt(counter++);
        else{
            counter = 0;
            return '-';
        }
    }
}
