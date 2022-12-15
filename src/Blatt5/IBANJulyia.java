package Blatt5;
import static jsTools.Input.*;

import static jsTools.Input.readChar;

public class IBANJulyia {
    public static long calcBBAN(long blz, long ktoNr){
        return Long.parseLong(String.valueOf(blz)+String.valueOf(ktoNr));                                   //*10 weil als eine Zahl wäre int zu gross
    }

    public static char toBig(char c){
        return Character.toUpperCase(c);
    }
    public static long calcLandKennung(char land1, char land2){
        return ((toBig(land1)-'A'+10)*100+(toBig(land2)-'A'+10))*100; //*10000 ansonsten wird der wert addiert und c-"A" bedeutete der Index in der Ascii tabelle
    }

    public static String calcPruefziffer(char land1, char land2, long BLZ, long KN){
        long BBAN = calcBBAN(BLZ, KN);
        long LK = calcLandKennung(land1, land2);
        long PZF = 98-((BBAN%97)*1000000 + LK)%97;
        if(PZF < 10){
            return "0" + String.valueOf(PZF);
        }
        return String.valueOf(PZF);
    }

    public static String calcIBAN(char land1, char land2,long blz, long ktoNr){
        String pruefziffer = calcPruefziffer(land1,land2,blz,ktoNr);
        return ""+toBig(land1)+toBig(land2)+pruefziffer+calcBBAN(blz,ktoNr);
    }





    //hier ergänzen sie die fehlenden Methoden
    //...

    public static void main (String args []){
        System.out.println();
        //pruefe Methoden:
        if ( 700901001234567890l !=calcBBAN (70090100, 1234567890))
            System.out.println("Fehler: Berechnung BBAN:"+
                    " 700901001234567890l != calcBban( 70090100, 1234567890)):"+
                    calcBBAN( 70090100, 1234567890));
        else System.out.println("IBAN OK");



        if ('A' !=toBig ('A'))
            System.out.println("Konvertierungsfehler: 'A' != toBig ('A')");
        else System.out.println("toBig('A')OK");
        if('A'!=toBig('a'))
            System.out.println("Konvertierungsfehler: 'A'!= toBig('a')");
        else System.out.println("toBig ('a') OK");
        if ('Z'!= toBig('z'))
            System.out.println("Konvertierungsfehler: 'Z' != toBig ('z')");
        else System.out.println (toBig ('z')+"toBig(z) OK");
        if( 'K'!= toBig('k'))
            System.out.println("Konvertierungsfehler: 'K' != toBig('k')");
        else System.out.println(toBig('k')+"toBig(k)OK");


        if ( 131400 != calcLandKennung( 'd','e'))
            System.out.println("Fehler: Berechnung Landkennung:" +
                    " 131400 != calcLandKennung( 'd','e') :"+
                    calcLandKennung( 'd','e'));
        else System.out.println("Landkennung OK");


        if(! "08".equals(calcPruefziffer('d','e',70090100, 1234567890)))
            System.out.println("Fehler: Berechnung Pruefziffer:"+
                    "08 !=calcPruefziffer('d','e',70090100,1234567890):"+
                    calcPruefziffer ('d','e',70090100, 1234567890));
        else System.out.println("Pruefziffer OK");


        if(! "DE08700901001234567890".equals(calcIBAN('d','e',70090100, 1234567890)))
            System.out.println("Fehler: Berechnung IBAN:"+
                    "DE08700901001234567890 ungleich"+
                    calcIBAN('d','e',70090100, 1234567890));
        else System.out.println("Berechnung IBAN: OK");

        char land1=readChar("Bitte geben Sie die erste Stelle der Laendererkennung ein:");
        char land2=readChar("Bitte geben Sie die zweite Stelle der Laendererkennung ein:");
        long blz=readInt("Bitte geben Sie die Bankleitzahl ein:");
        long kontoNr=readInt("Bitte geben Sie die Kontonummer ein:");

        //Hier folgt der Aufruf fuer die Berechnung: und die Ausnahme
        System.out.println("IBAN:"+calcIBAN('d','e',blz, kontoNr));

    }

}
