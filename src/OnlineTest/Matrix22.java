package OnlineTest;

public class Matrix22 {
    static int[][] genMatrix(int dimR, int dimS, int val){
        int[][] matrix = new int[dimR][dimS];
        for(int i = 0; i < matrix.length;i++){
            if(i == 0 || i == matrix.length-1){
                for(int j = 0; j < matrix[i].length;j++){
                    matrix[i][j] = val;
                }
            } else {
                matrix[i][0] = val;
                matrix[i][matrix[i].length-1] = val;
            }
        }
        return matrix;
    }

    static int[][] mixMatrix(int[][] m1, int[][] m2){
        int x = Math.max(m1.length, m2.length);
        int y = Math.max(m1[0].length, m2[0].length);
        int[][] matrix = new int[x][y];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m1[i].length;j++){
                matrix[i][j] = m1[i][j];
            }
        }
        for(int i = 0; i < m2.length; i++){
            for(int j = 0; j < m2[i].length;j++){
                matrix[i][j] += m2[i][j];
            }
        }
        return matrix;
    }

    static void exChangeCol(int[][] m1, int c1, int c2){
        int[] temp = m1[c1];
        m1[c1] = m1[c2];
        m1[c2] = temp;
    }

    static void fillRand(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length;j++){
                m[i][j] = (int) (100*Math.random());
            }
        }
    }
}
