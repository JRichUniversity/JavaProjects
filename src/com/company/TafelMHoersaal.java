package com.company;

public class TafelMHoersaal {
    static int hoehe;
    static int breite;

    int posAufSchienen = 0;
    char schiene = 'v';
    char liOrRe = 'l';
    String inhalte = "";

    TafelMHoersaal(char _schiene, char _liOrRe){
        schiene = _schiene;
        liOrRe = _liOrRe;
    }

    void move(int posNeu){
        posAufSchienen = posNeu;
    }

    void aBisserlRauf(){
        posAufSchienen = posAufSchienen + 50;
    }
}

class Prog_20221124{
    public static void main(String[] args){
        TafelMHoersaal t1 = new TafelMHoersaal('v', 'l');
        TafelMHoersaal t2 = new TafelMHoersaal('h', 'r');
        t1.move(200);
        t2.move(50);
        t2.liOrRe = 'r';
    }
}
