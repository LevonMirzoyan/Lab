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






public class lab3_5 {
    public static void main(String args[]){
        ConstructtheDeBruijnGraphh IME = new ConstructtheDeBruijnGraphh();
        IME.result();
    }
}


class ConstructtheDeBruijnGraphh{
    ArrayList<String> pattern = new ArrayList<>();

    TreeMap<String,ArrayList<String>> map= new TreeMap<>();

    ConstructtheDeBruijnGraphh(){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){

            pattern.add(in.next());

        }
        in.close();
    }

    TreeMap<String,ArrayList<String>> printRes() {
        int k = pattern.get(0).length();
        for (int i=0; i< pattern.size(); i++){
            String str = pattern.get(i);
            String a = str.substring(0,k-1);
            String b = str.substring(1,k);
            if (!map.containsKey(a)) {
                map.put(a,new ArrayList<>());
            }
            map.get(a).add(b);
        }






        return map;
    }

    void result() {
        TreeMap<String,ArrayList<String>> map = printRes();
        for(String s: map.keySet()){
            System.out.print(s);
            System.out.print(" -> ");
           /* for(String i : printRes().get(s)){
                if (!tmp.contains(i)) {
                    tmp.add(i);
                }
            }*/
            boolean flag = true;
            for(String i: map.get(s)) {
                if(flag) {
                    flag = false;
                }
                else {
                    System.out.print(',');
                }
                System.out.print(i);
            }
            System.out.print('\n');
            // tmp.clear();
        }
    }
}