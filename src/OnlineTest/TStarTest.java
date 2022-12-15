package OnlineTest;
public class TStarTest {
    static int checkTstar(int h, int lge){
        int p=0;
        int l=lge/2;
        String regex= "([ ]{"+h+"}\\* *\n){"+ (l)+"}[*]{"+ (h+1)+"} *\n([ ]{"+h+"}\\* *\n){"+ (l)+"}[ \n]*";
        //System.out.println("@@@@@@@@ regex:"+regex+"|");
        String s=TStar.genTstar(h,lge);
        if (s==null) return 0;
        System.out.println(s);
        boolean ck=s.matches(regex);
        if (ck){
            System.out.println("TStar "+h+","+lge+ " OK");
            p++;
        } else
          System.out.println("TStar "+h+","+lge+ " NOK");
        return p;
    }
    public static void main(String a[]){
        int p= checkTstar(2,6);
        p   += checkTstar(4,4);
        p   += checkTstar(5,9);
        p   += checkTstar(16,5);

        System.out.println("TStar: ======================== "+p+ " von "+4);
    }
}
