import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class lab3_3 {
    public static void main(String args[]){
        ConstructTheOverlapGraphofaCollection IME = new ConstructTheOverlapGraphofaCollection();
        IME.overlap();
    }
}

class ConstructTheOverlapGraphofaCollection{
    ArrayList<String> patterns;
    ConstructTheOverlapGraphofaCollection(){
        Scanner in = new Scanner(System.in);
        patterns = new ArrayList<String>();
        while(in.hasNext()) {
            patterns.add(in.next());
        }
    }
    String prefix(String str) {
        return str.substring(0, str.length()-1);
    }
    String suffix(String str) {
        return str.substring(1, str.length());
    }
    void overlap() {
        int pat_len = patterns.size();
        TreeMap<String, String> pairs = new TreeMap<>();
        for(int i = 0; i<pat_len; i++) {
            for(int j = 0; j<pat_len; j++) {
                if(i!=j && suffix(patterns.get(i)).contains(prefix(patterns.get(j)))) {
                    pairs.put(patterns.get(i), patterns.get(j));
                }
            }
        }
        for(String i: pairs.keySet()) {
            System.out.print(i);
            System.out.print(" -> ");
            System.out.println(pairs.get(i));
        }
    }

}