import java.util.*;



public class lab1_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Character> arr = new ArrayList<>();
        arr.add('A');
        arr.add('C');
        arr.add('G');
        arr.add('T');
        String str = in.next();
        int n = in.nextInt();
        for(String i: fun(str, n, arr)) {
            System.out.print(i);
            System.out.print('\n');
        }
        System.out.print(str);
    }
    static ArrayList<String>fun(String pattern, int d, ArrayList<Character> arr) {
        if(d==0) {
            ArrayList<String> rr = new ArrayList<>();
            rr.add(pattern);
            return rr;
        }
        ArrayList<String> r2 = new ArrayList<>();
        r2 = fun(pattern.substring(1), d-1, arr);
        ArrayList<String> r = new ArrayList<>();
        for(String r3: r2) {
            for(Character elem: arr) {
                if(elem!=pattern.charAt(0)) {
                    r.add(Character.toString(elem) + r3);
                }
            }
        }

        if(d<pattern.length()) {
            r2 = fun(pattern.substring(1), d, arr);
            for(String r3: r2) {
                r.add(Character.toString(pattern.charAt(0))+r3);
            }
        }
        return r;
    }
}