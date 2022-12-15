package OnlineTest;

public class Nikolaus22 {
    String[] geschenkeSack;
    String goldenesBuch;
    int geschenkeImSack;

    int geschenkeCounter = 0;

    Nikolaus22(String goldenesBuch){
        this.goldenesBuch = goldenesBuch;
        geschenkeSack = new String[10];
    }

    void putPraesent(String praesent){
        if(geschenkeImSack < geschenkeSack.length){
            geschenkeImSack++;
            geschenkeSack[geschenkeImSack-1] = praesent;
        }
    }

    void putPraesente(String praesente[]){
        int index = 0;
        while(geschenkeImSack < geschenkeSack.length && index < praesente.length){
            putPraesent(praesente[index]);
            index++;
        }
    }

    String getAPraesent(){
        if(geschenkeImSack == 0){
            return "Sorry Sack ist leer";
        }
        else {
            String geschenk = geschenkeSack[geschenkeImSack-1];
            geschenkeSack[geschenkeImSack-1] = null;
            geschenkeImSack--;
            return geschenk;
        }
    }
}
