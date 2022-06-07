import java.util.*;


public class lab1_13 {
    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();

        dict.put("0", "A");
        dict.put("1", "C");
        dict.put("2", "G");
        dict.put("3", "T");

        Scanner sc = new Scanner(System.in);

        Long value = sc.nextLong();
        Integer size = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        while (value != 0) {
            arr.add((int)(value % 4));
            value /= 4;
        }

        StringBuilder res = new StringBuilder();

        for (Integer elem : arr)
            res.append(dict.get(elem.toString()));

        for (int i = 0; i < size - arr.size(); i++)
            res.append("A");
        res.reverse();
        System.out.print(res);
    }
}