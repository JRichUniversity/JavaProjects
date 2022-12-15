package Blatt9;

import static jsTools.Input.*;
public class Student {
    String vorname;
    String nachname;
    String studiengang;
    int semester;
    int ects;

    static int anz_studierende;
    final int max_semester = 10;

     public Student(String vn, String nn, String sg){
        this.vorname = vn;
        this.nachname = nn;
        this.studiengang = sg;
        anz_studierende++;
        this.semester = 1;
    }

    public Student(){
        String vn = readLine("Bitte Vorname eingeben: ");
        String nn = readLine("Bitte Nachname eingeben: ");
        String sg = readLine("Bitte Studiengang eingeben: ");
        this.vorname = vn;
        this.nachname = nn;
        this.studiengang = sg;
    }

    public String toString(){
        return vorname + " " + nachname + ", " +studiengang;
    }

    public int getStudenten(){
        return anz_studierende;
    }

    public void setECTS(int ects){
        this.ects = ects;
    }

    public boolean vorruecken(){
        int next_sem = semester;
        if(semester < max_semester){
            if(semester == 2 && ects >= 30){
                semester++;
            }
            else if (semester == 4 && ects >= 90){
                semester++;
            }
            else if (semester == 5 && ects >= 105){
                semester++;
            }
            else if (semester != 2 && semester != 4 && semester != 5){
                semester++;
            }
        }
        System.out.println(next_sem + " " + semester);
        return next_sem < semester;
    }

    public int getInstanzen(){
        return anz_studierende;
    }
}
