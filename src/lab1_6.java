import java.util.*;

import java.util.Scanner;

public class lab1_6 {

    public static void main(String[] args) {



        String a;
        int c = 0, g = 0, m = 0;
        Scanner in = new Scanner(System.in);
        a = in.next();

        in.close();

        HashMap<Integer, Integer> d = new HashMap<>();
        char[] aa = a.toCharArray();

        for (int i = 0; i < a.length() ; i++) {
            if(aa[i] == 'C'){
                c++;
            }
            else if(aa[i] == 'G'){
                g++;
            }
            d.put(i,g-c);
            if (d.get(i) < m){
                m = d.get(i);
            }
        }
        for (Map.Entry<Integer, Integer> entry : d.entrySet()) {
            if(entry.getValue()== m) {
                System.out.print(entry.getKey() + 1 + " ");
            }
        }
    }

}