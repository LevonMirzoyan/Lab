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





public class lab3_2 {
    public static void main(String args[]){
        ReconstructaStringfromitsGenome IME = new ReconstructaStringfromitsGenome();
        IME.result();
    }
}


class ReconstructaStringfromitsGenome{

    ArrayList <String> Dna;

    ReconstructaStringfromitsGenome(){
        Scanner in = new Scanner(System.in);
        Dna = new ArrayList<>();
        while(in.hasNext()){

            String str = in.next();
            Dna.add(str);

        }

        in.close();
    }




    String printRes() {
        String res = "";
        int k = Dna.get(0).length();


        for (String s : Dna){
            res += s.charAt(0);



        }
        res += Dna.get(Dna.size()-1).substring(1,k);
        return res;
    }

    void result() {
        System.out.print( printRes());

    }
}