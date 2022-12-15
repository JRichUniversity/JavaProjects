package OnlineTest;

public class TStar {
    static String genTstar(int h, int lge){
        String str = "";
        if(lge%2 == 0) lge++;
        for(int i = 0; i < lge; i++){
            if(i != lge/2){
                str += " ".repeat(h) + "*\n";
            }
            else str += "*".repeat(h+1) + "\n";
        }
        return str;
    }
}
