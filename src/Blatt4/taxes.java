package Blatt4;

public class taxes {
    static int numP = 2;
    static double grossIncomePer1 = 271300;
    static double grossIncomePer2 = 14652;

    public static void main(String[] args){
        /*
        double taxes;
        double income;
        if(numP == 1){
            taxes = grossIncomeTax(grossIncomePer1);
            income = grossIncomePer1;
        }
        else if(numP == 2){
            taxes = 2 * grossIncomeTax((grossIncomePer1+grossIncomePer2)/2);
            income = grossIncomePer1+grossIncomePer2;
        }
        else{
            System.out.println("Bitte valide Anzahl an Personen eintragen");
            return;
        }
        System.out.println("Einkommensteuer für " + numP  + " mit Einkommen "+ income + "€ beträgt: " + Math.round(taxes * 100) / 100 + "€");
        */
        printEstTab(1000, 150000, 1000);
    }


    public static double grossIncomeTax(double income){
        if(inRange(income, 0, 9408)){
            return 0;
        }
        else if(inRange(income, 9409,14532)){
            double y = (income - 9048) / 10000;
            return (972.87 * y + 1400) * y;
        }
        else if(inRange(income, 14533,57051)){
            double z = (income - 14532) / 10000;
            return (212.02 * z + 2397) * z + 972.79;
        }
        else if(inRange(income, 57052, 270500)){
            return 0.42 * income - 8963.74;
        }
        else if(income >= 270501){
            return 0.45 * income - 17078.74;
        }
        else return 0;
    }

    public static boolean inRange(double num, double min, double max){
        if(num >= min && num <= max) return true;
        else return false;
    }

    public static void printEstTab(double min, double max, double increment){
        System.out.println("Einkommen\tEine Persone\tZwei Personen");
        for(double i = min; i < max; i = i + increment){
            System.out.print(Math.round(i) + "\t\t" + Math.round(grossIncomeTax(i)));
            if(Math.round(grossIncomeTax(i)) < 1000){
                System.out.print("\t");
            }
            System.out.println("\t\t\t" + Math.round(2 * grossIncomeTax(i/2)));
        }
    }
}
