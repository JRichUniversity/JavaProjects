package Blatt7;

public class Person {
    static int pnr;
    static String name;
    static int zip;
    static String ort;

    public Person(int p, String n, int z, String o){
        pnr = p;
        name = n;
        zip = z;
        ort = o;
    }

    public static void printInfo(){
        System.out.println(pnr + " " + name + " " + zip + " " + ort);
    }
}
