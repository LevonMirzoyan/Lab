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






public class lab3_4 {
    public static void main(String args[]){
        ConstructtheDeBruijnGraph IME = new ConstructtheDeBruijnGraph();
        IME.result();
    }
}


class ConstructtheDeBruijnGraph{
    int k;
    String text;
    TreeMap<String,ArrayList<String>> map= new TreeMap<>();

    ConstructtheDeBruijnGraph(){
        Scanner in = new Scanner(System.in);
        k = in.nextInt();
        text = in.next();
        in.close();
    }

    TreeMap<String,ArrayList<String>> printRes() {
        for (int i=0; i< text.length()-k+1; i++){
            if (!map.containsKey(text.substring(i, i + k - 1))) {
                map.put(text.substring(i, i + k - 1),new ArrayList<>());
            }
            map.get(text.substring(i, i + k-1)).add(text.substring(i+1, i + k));
        }
        return map;
    }

    void result() {
        TreeSet<String> tmp = new TreeSet<String>();
        for(String s: printRes().keySet()){
            System.out.print(s);
            System.out.print(" -> ");
            for(String i : printRes().get(s)){
                if (!tmp.contains(i)) {
                    tmp.add(i);
                }
            }
            boolean flag = true;
            for(String i: tmp) {
                if(flag) {
                    flag = false;
                }
                else {
                    System.out.print(',');
                }
                System.out.print(i);
            }
            System.out.print('\n');
            tmp.clear();
        }
    }
}