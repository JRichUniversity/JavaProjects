package Blatt5;

import jsTools.Input;

public class IBAN {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String args[]){
        if(700901001234567890l != calcBBAN(70090100, 1234567890)){
            System.out.println("Fehler: Berechnung BBAN" + "700901001234567890 l ! = calcBban ( 70090100 , 1234567890)):" +
                    calcBBAN (70090100 , 1234567890));
        }
        else System.out.println("IBAN OK");

        tests();
        int[][] hallo = {{1,2,3,4}};

        //System.out.println(accountNrLenght(70090100, 1234567890));
    }

    public static int accountNrLenght(long blz, long kn){
        char[] account = (""+ blz + kn).toCharArray();
        return account.length;
    }


    public static long calcBBAN(long blz, long ktoNR){
        return Long.parseLong(String.valueOf(blz) + String.valueOf(ktoNR));
    }

    public static char toBig(char c){
        if((int)c >= (int)"a".charAt(0) && (int)c <= (int)"z".charAt(0)){
            return Character.toUpperCase(c);
        }
        else return c;
    }

    public static long calcLandKennung(char land1, char land2){
        return (ALPHABET.indexOf(toBig(land1))+10)*10000 + (ALPHABET.indexOf(toBig(land2))+10)*100;
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

    public static String calcIBAN(char land1, char land2, long BLZ, long KN){
        return "" + toBig(land1) + toBig(land2) + calcPruefziffer(land1, land2, BLZ, KN) + BLZ + KN;
    }

    public static void tests(){
        String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("Capital-letters:\t");
        for(char c : ALPHABET.toCharArray()){
            System.out.print(toBig(c) + "\t");
        }
        System.out.print("\n\nSmall-letters:\t\t");
        for(char c : smallAlphabet.toCharArray()){
            System.out.print(toBig(c) + "\t");
        }
        if(131400 != calcLandKennung((char)0x64,(char)0x65)){
            System.out.println("\n\nFehler bei Länderkennung.");
        } else System.out.println("\n\nLänderkennung: "+ calcLandKennung((char)0x64,(char)0x65));

        System.out.println("\nPrüfziffer: " + calcPruefziffer((char)0x64 , (char)0x65 ,70090100 , 1234567890));

        System.out.println("\n"+ calcIBAN((char)0x64 , (char)0x65 ,70090100 , 1234567890));
    }
}
