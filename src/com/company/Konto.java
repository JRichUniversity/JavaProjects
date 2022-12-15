package com.company;
public class Konto {
    static int firstNr = 1000;
    int ktoNr;
    String besitzer;
    int saldo;
    int ktoBew;

    Konto(String name){
        ktoNr = firstNr++;
        besitzer = name;
        saldo = 0;
        ktoBew = 0;
    }

    void ueberweisung(int val){
        ktoBew++;
        saldo += val;
    }

    int abrechnung(){
        saldo -= ktoBew * 10;
        int bewegungen = ktoBew;
        ktoBew = 0;
        return bewegungen;
    }
}
