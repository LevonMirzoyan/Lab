import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;





public class lab3_1 {
    public static void main(String[] args){
        GenerateCompositionn IME = new GenerateCompositionn();
        IME.result();
    }
}


class GenerateCompositionn{
    int k;
    String text ;


    GenerateCompositionn(){
        Scanner in = new Scanner(System.in);

        k = in.nextInt();
        text = in.next();

        in.close();
    }




    TreeSet<String> printRes() {
        TreeSet <String> res = new TreeSet<>();
        for (int i=0; i< text.length() - k + 1; i++){
            res.add(text.substring(i,i+k));


        }
        return res;
    }

    void result() {
        for (String logic:printRes()) {
            System.out.println(logic);
        }

    }
}