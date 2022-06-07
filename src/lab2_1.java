import java.util.*;


public class lab2_1
{
    public static void main(String args[]){
        ImplementMotifEnumeration IME = new ImplementMotifEnumeration();
        IME.sum();
    }
}


class ImplementMotifEnumeration{
    int k, d;

    ArrayList<String> Dna;
    ImplementMotifEnumeration(){
        Scanner in = new Scanner(System.in);
        Dna = new ArrayList<String>();
        k = in.nextInt();
        d = in.nextInt();
        while(in.hasNext()) {

            String str = in.next();
            Dna.add(str);
        }
        in.close();
    }
    ArrayList<String> neighbours(int d, String pattern){
        HashSet<String> nbs = new HashSet<>();
        Set<String> nbprime = new HashSet<>();
        int size = pattern.length();
        char[] nkl = {'A', 'C', 'G', 'T'};
        nbs.add(pattern);
        for(int i =0; i<d; i++) {
            for(String str: nbs) {
                char[] arrChar = str.toCharArray();
                for(int j = 0; j<size; j++) {
                    char old = arrChar[j];
                    for(char elem: nkl) {
                        arrChar[j] = elem;
                        nbprime.add(String.copyValueOf(arrChar));
                    }
                    arrChar[j] = old;
                }
            }
            nbs.addAll(nbprime);
            nbprime.clear();
        }
        ArrayList<String> res = new ArrayList<String>(nbs);
        Collections.sort(res);
        return res;
    }

    ArrayList<String> motifEnumeration(ArrayList<String> Dna, int k, int d){
        HashSet<String> patterns = new HashSet<>();
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        String str1 = Dna.get(0);
        int size = Dna.size();
        int length = str1.length();
        for(int i = 0; i<=str1.length()-k; i++) {
            String str = str1.substring(i, i+k);
            ArrayList<String> resTmp = neighbours(d, str);
            for(String elem: resTmp) {
                int count = 1;
                for(int j=1; j<size; j++) {
                    String strn = Dna.get(j);
                    ArrayList<String> arrResStrN = neighbours(d, strn);
                    boolean flag = false;
                    for(String st: arrResStrN) {
                        for(int l = 0; l<=length-k; l++) {
                            if(elem.equals(st.substring(l, l+k))) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(flag) {
                        count++;
                    }
                    else {
                        break;
                    }

                }
                if(count == size) {
                    patterns.add(elem);
                }
            }
        }
        ArrayList<String> res = new ArrayList<String>(patterns);
        Collections.sort(res);
        return res;
    }

    void printRes(ArrayList<String> res) {
        boolean first = true;
        for(String i: res) {
            if(first) {
                first = false;
            }
            else {
                System.out.print(" ");
            }
            System.out.print(i);
        }
        System.out.println();
    }

    void sum() {
        printRes(motifEnumeration(Dna, k, d));
    }
}