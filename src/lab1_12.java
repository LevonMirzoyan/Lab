import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lab1_12 {
    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();

        dict.put("A", "0");
        dict.put("C", "1");
        dict.put("G", "2");
        dict.put("T", "3");

        String pattern = new Scanner(System.in).next();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<pattern.length(); i++)
            res.append(dict.get(String.valueOf(pattern.charAt(i))));

        System.out.println(Long.parseLong(res.toString(), 4));
    }
}