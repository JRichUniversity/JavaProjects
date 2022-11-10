package Blatt4;

public class ASCII {

    public static void main(String[] args){
        for(int i = 1; i < 24; i++){
            System.out.println(decryptText("HPC SLE KFPCDE OLD CLPEDPW RPWZPDE - PC DNSCPTMP XTC MTEEP PTYP XLTW", i));
        }
    }

    public static char crypt(char c, int i){
        int posC = c;
        if(posC >= 0x62 && posC <= 0x7A){
            if(c+i > 0x7A){
                return (char)(c + i - 26);
            }
            else return (char)(c + i);
        }
        else if (posC >= 0x41 && posC <= 0x5A){
            if(c+i > 0x5A){
                return (char)(c + i - 26);
            }
            else return (char)(c + i);
        }
        else return c;
    }

    public static char decrypt(char c, int i){
        int posC = c;
        if(posC >= 0x62 && posC <= 0x7A){
            if(c - i < 0x62){
                return (char)(c - i + 26);
            }
            else return (char)(c - i);
        }
        else if (posC >= 0x41 && posC <= 0x5A){
            if(c - i < 0x41){
                return (char)(c - i + 26);
            }
            else{
                return (char)(c - i);
            }
        }
        else return c;
    }

    public static String cryptText(String s, int n){
        char[] sentence = s.toCharArray();
        StringBuilder g = new StringBuilder();
        for(char c : sentence){
            g.append(crypt(c, n));
        }
        return g.toString();
    }

    public static String decryptText(String s, int n){
        char[] sentence = s.toCharArray();
        StringBuilder g = new StringBuilder();
        for(char c : sentence){
            g.append(decrypt(c, n));
        }
        return g.toString();
    }
}
