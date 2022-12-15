package OnlineTest;
import java.util.Vector;

public class Nikolaus22Test {
    public static void main(String a[]){
        int pkt=0;
        Nikolaus22 nikolaus1=new Nikolaus22("top secret");
        if (nikolaus1.goldenesBuch.equals("top secret"))
            pkt++;

        nikolaus1.putPraesent("Orange");

        String p1 = nikolaus1.getAPraesent();

        if (p1.equals("Orange")){
            pkt++;
        }
        p1=nikolaus1.getAPraesent();
        if (p1.equals("Sack ist leer")){
            pkt++;
        }
        Vector<String> pr=new Vector<>();
        pr.add("P1");
        pr.add("P2");
        nikolaus1.putPraesent("P1");
        nikolaus1.putPraesent("P2");
        String ps[]={"P3","P4","P5"};
        nikolaus1.putPraesente(ps);
        for (String s: ps ) {
            pr.add(s);
        }

        Vector<String> pr2=new Vector<>();
        for (int i = 0; i <7 ; i++) {
            pr2.add(nikolaus1.getAPraesent());
        }

        for (String px:pr ) {
            if (pr2.contains(px)) {
                pkt++;
                System.out.println("Da: "+px);
            } else System.out.println("Nicht da:"+px);
        }

        System.out.println("Nikolaus hat "+pkt+ "Punkte von 8");
    }
}
