import java.util.*;

import java.util.Scanner;

public class lab1_4 {

    public static void main(String[] args) {

        int answer;

        String text;
        String pattern;
        Scanner in = new Scanner(System.in);
        pattern = in.next();
        text = in.next();

        in.close();



        int cnt = 0;
        int tlen = text.length();
        int plen = pattern.length();
        //  Set set = new HashSet();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < tlen - plen + 1; i++) {
            String cmp = text.substring(i, i + plen);
            if (cmp.equals(pattern)) {
                cnt++;
                set.add(i);
            }
        }
        for ( Integer s : set )
            System.out.print(s+ " ");
    }

}