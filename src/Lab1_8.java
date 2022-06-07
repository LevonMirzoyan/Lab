import java.util.*;

import java.util.Scanner;

public class Lab1_8 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String pattern = in.next();
        String genome = in.next();

        int mismatches = in.nextInt();

        ArrayList<Integer> startPositions = Approximate_Occurrences_of_a_Pattern(pattern, genome, mismatches);
        for (Integer startPosition : startPositions) {
            System.out.print(startPosition + " ");
        }
    }

    public static ArrayList<Integer> Approximate_Occurrences_of_a_Pattern(String pattern, String genome, int mismatches) {
        ArrayList<Integer> startPositions = new ArrayList<Integer>();
        for (int i = 0; i < genome.length() - pattern.length(); i++) {
            String substring = genome.substring(i, i + pattern.length());
            if(isApproximateMatching(pattern, substring, mismatches))
                startPositions.add(i);
        }
        return startPositions;
    }

    private static boolean isApproximateMatching(String pattern, String substring, int mismatches) {
        char[] patternChars = pattern.toCharArray();
        char[] substringChars = substring.toCharArray();
        for (int i = 0; i < patternChars.length; i++) {
            if(patternChars[i] != substringChars[i])
                mismatches--;
            if(mismatches < 0)
                return false;
        }
        return true;
    }
}