package Uebung3;

import static jsTools.Input.readLine;

public class TimeStamp {
    static final String[] singleTimes = {"null", "ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf"};
    static final String[] intervalTen = {"zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig", "siebzig", "achtzig", "neunzig"};
    static final String[] exceptions = {"sechzehn", "siebzehn"};
    static final String connector = "und";

    private static String interpret(int i){
        if(0 <= i  || i <= 99){
            if(i == 1) return singleTimes[i]+"s";
            else if(i != 1 && i <= 12) return singleTimes[i];
            else if (i < 20){
                if(i != 16 && i != 17){
                    return singleTimes[i % 10] + singleTimes[10];
                }
                else if (i == 16) return exceptions[0];
                else return exceptions[1];
            }
            else if (i >= 20 && i % 10 == 0) return intervalTen[i / 10 - 2];
            else return singleTimes[i % 10] + connector + intervalTen[i / 10 - 2];
        }
        else return null;
    }

    private static boolean check(int[] time){
        return time[0] >= 0 && time[0] <= 23 && time[1] >= 0 && time[1] <= 59 && time[2] >= 0 && time[2] <= 59;
    }

    public static void printTimeAsText(int std, int min, int sec){
        int[] arr = {std, min, sec};
        if(check(arr)) Printer.println("Es ist " + interpret(std) + " Uhr " + interpret(min) + " Minuten und " + interpret(sec) + " Sekunden");
        else Printer.println("Invalid Input");
    }

    public static void time2text(){
        String time = readLine("Please enter a time(hh:mm:ss): ");
        try {
            String[] times = time.split("[:]");
            printTimeAsText(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));
        } catch (Exception e){
            Printer.println("Wrong time format. Please try again");
            time2text();
        }
    }
}
