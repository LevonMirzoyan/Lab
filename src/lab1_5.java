import java.util.Scanner;
import java.util.*;

public class lab1_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String genome = in.next();
        int k = in.nextInt();
        int l = in.nextInt();
        int t = in.nextInt();

        ArrayList<String> patternsFormingClumps = fetchAllDistinctPatternsFormingClumps(genome, k, t, l);
        for (String pattern : patternsFormingClumps) {
            System.out.print(pattern + " ");
        }
    }

    public static ArrayList<String> fetchAllDistinctPatternsFormingClumps(String genome, int k, int t, int clumpsLength) {
        ArrayList<String> patternsFormingClumps = new ArrayList<String>();

        ArrayList<String> patterns = fetchFrequentPattern(genome, k, t);
        for (String pattern : patterns) {
            if(isFormingClumps(genome, pattern, clumpsLength, t))
                patternsFormingClumps.add(pattern);
        }
        return patternsFormingClumps;
    }

    private static ArrayList<String> fetchFrequentPattern(String genome, int length, int minOccurredCount) {
        ArrayList<String> patterns = new ArrayList<String>();

        int lastIndex = genome.length() - length;
        for (int i = 0; i <= lastIndex; i++) {
            String pattern = genome.substring(i, length+i);

            if(patterns.contains(pattern))
                continue;

            // Count pattern occurred times.
            int occurredCount = PatternMatchingProblem(pattern, genome).size();

            if(occurredCount >= minOccurredCount)
                patterns.add(pattern);
        }

        return patterns;
    }

    private static boolean isFormingClumps(String genome, String pattern, int clumpsLength, int t) {
        ArrayList<Integer> patternPositions = PatternMatchingProblem(pattern, genome);
        for (int i = 0; i <= patternPositions.size() - t; i++) {
            int endIndex = patternPositions.get(i + t - 1) + pattern.length();
            int startIndex = patternPositions.get(i);
            if(endIndex - startIndex <= clumpsLength)
                return true;
        }
        return false;
    }
    public static ArrayList<Integer> PatternMatchingProblem(String pattern, String genome) {

        ArrayList<Integer> indexes = new ArrayList<>();
        int lastOccurredIndex = genome.indexOf(pattern);
        while (lastOccurredIndex != -1) {
            indexes.add(lastOccurredIndex);
            lastOccurredIndex = genome.indexOf(pattern, lastOccurredIndex + 1);
        }
        return indexes;

    }

}