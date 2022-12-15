package OnlineTest;
//import static Matrix22;
public class Matrix22Test {

    // support methods
    static void pr(int m[][]){
        for (int i = 0; i <m.length ; i++) {
            for (int j=0; j< m[0].length;j++) {
                System.out.print(m[i][j]+ "  ");
            }
            System.out.println();
        }
        System.out.println(" --   sum of elements= "+sum(m)+"-----");
        System.out.println("=========================================");
    }

    static int sum(int[][] m){
        int res=0;
        for (int i = 0; i <m.length ; i++) {
            for (int j=0; j< m[0].length;j++) {
                res+=m[i][j];
            }
        }
        return res;
    }
    static int checkMat(String check, int[][] mat4Check,int d1, int d2, int m00, int m12, int sum) {
        int p = 0;
        System.out.println("checkMat for: "+check);
        if (mat4Check.length == d1 && mat4Check[0].length == d2) {
            p++;
            System.out.println("    Dimension mixmatrix OK");
        }
        if (mat4Check[0][0] == m00) {
            p++;
            System.out.println("    r[0][0] OK");
        }
        if (mat4Check[1][2] ==m12) {
            p++;
            System.out.println("    r[1][2] ==0  OK");
        }
        if(sum(mat4Check)==sum) {
            p++;
            System.out.println("    sum mixMatrix OK");
        }
        System.out.println("checkMat-"+check+" "+p+" of "+4);
        return p;
    }
    public static void main(String a[]){
        int p=0;
        try {
            int mat4Test[][] = Matrix22.genMatrix(3, 5, 3);

            p += checkMat("mat4test", mat4Test, 3, 5, 3, 0, 36);
            int mat2_4Test[][] = Matrix22.genMatrix(6, 4, 9);
            p += checkMat("mat2_4Test", mat2_4Test, 6, 4, 9, 0, 144);

            int resultMix[][] = Matrix22.mixMatrix(mat2_4Test, mat4Test);

            p += checkMat("resultMix", resultMix, 6, 5, 12, 0, 180);
        } catch (Exception e){
            e.printStackTrace();
        }

        int dimRmat=100;
        int randM[][]=new int[dimRmat][dimRmat];
        try {
            Matrix22.fillRand(randM);
            int sm = sum(randM) - dimRmat * dimRmat * 50;
            final int DELTA = dimRmat * dimRmat * 50 / 10;   //10% Abweichung
            System.out.printf("fillRand: %5.2f", (float) sm / sum(randM));
            if (Math.abs(sm) < DELTA) {
                p++;
                System.out.println(" accepted == OK");
            } else {
                System.out.println(" ???? sm=" + sm + " " + sum(randM));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int[][] exMat=new int[4][5];
        try {
            Matrix22.fillRand(exMat);
            exMat[0][0] = -999;
            exMat[0][2] = 1111;
            int exs = sum(exMat);
            Matrix22.exChangeCol(exMat, 0, 2);
            //pr(exMat);
            if (exMat[0][0] == 1111 && exMat[0][2] == -999) {
                p++;
                System.out.println("exChangeCol [0] 0-2 OK");
            }
            if (exs == sum(exMat)) {
                p++;
                System.out.println("exChangeCol sum OK");
            }
        }catch (Exception e){
           e.printStackTrace();
        }

        System.out.println("====================== Punktesumme Mattrix22: "+p+" of 15");
    }
}
