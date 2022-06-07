import java.util.*;

import java.util.Scanner;

public class lab1_1 {

    public static void main(String[] args) {
        ComputeTheNumberOfTimesAPatternAppearsInATextImpl cntpa =
                new ComputeTheNumberOfTimesAPatternAppearsInATextImpl();
        cntpa.solve();
        cntpa.print();
    }

}

class ComputeTheNumberOfTimesAPatternAppearsInATextImpl {

    ComputeTheNumberOfTimesAPatternAppearsInATextImpl() {
        Scanner in = new Scanner(System.in);
        text = in.next();
        pattern = in.next();
        in.close();
    }

    int count(String txt, String ptrn) {
        int cnt = 0;
        int tlen = txt.length();
        int plen = ptrn.length();

        for (int i = 0; i < tlen - plen + 1; i++) {
            String cmp = txt.substring(i, i + plen);
            if (cmp.equals(ptrn)) {
                cnt++;
            }
        }
        return cnt;
    }

    void solve() {
        answer = count(text, pattern);
    }

    void print() {
        System.out.println(answer);
    }

    int answer;

    String text;
    String pattern;
}