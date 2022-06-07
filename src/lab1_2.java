import java.util.*;


public class lab1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();

        ArrayList<String> patterns = MostFrequentWords(str, k);

        for (String pattern : patterns) {
            System.out.print(pattern + " ");
        }
    }

    public static ArrayList<String> MostFrequentWords(String str, int k) {
        ArrayList<String> patterns = new ArrayList<String>();
        int max = 0;

        int lastIndex = str.length() - k;
        for (int i = 0; i <= lastIndex; i++) {
            String pattern = str.substring(i, k+i); // получить паттерн.

            if(patterns.contains(pattern)) // если бы мы находим этот паттерн, просто продолжаем цикл.
                continue;

            // Количество раз встречавшихся паттернов.
            int occurredCount = getPositions(pattern, i, str).size();

            if(occurredCount > max) {
                patterns.clear();
                patterns.add(pattern);
                max = occurredCount;
            } else if(occurredCount == max) {
                patterns.add(pattern);
            }
        }

        return patterns;
    }

    public static ArrayList<Integer> getPositions(String pattern, int startIndex, String genome) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int lastIndex = startIndex;
        while (lastIndex != -1) {
            indexes.add(lastIndex);
            lastIndex = genome.indexOf(pattern, lastIndex + 1);
        }
        return indexes;
    }
}