import java.util.*;


import java.util.List;

import java.util.Arrays;

import java.util.Set;

import java.util.HashSet;

public class lab3_8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        List <String> kmers;
        kmers = new ArrayList<>();
        while(in.hasNext()){
            String str = in.next();
            kmers.add(str);
        }

        in.close();


        System.out.println(construct(k, kmers));

    }


    public static String construct(int k, List<String> kmers) {

        if (!kmers.isEmpty()) {

            for (int i = 0; i < kmers.size(); i++) {

                StringBuilder result = new StringBuilder(kmers.get(i));

                Set<Integer> unvisited = new HashSet<>();

                for  (int j = 0; j < kmers.size(); j++) {

                    if (j != i) {

                        unvisited.add(j);

                    }

                }

                if (traverse(k, kmers, unvisited, result)) {

                    return result.toString();

                }

            }

        }

        return "";

    }

    private static boolean traverse( int k,  List<String> kmers,  Set<Integer> unvisited,  StringBuilder builder) {

        if (unvisited.isEmpty()) {

            return true;

        }

        String prefix = builder.substring(builder.length() - k + 1);

        Set<Integer> remaining = new HashSet<>();

        for ( int next : unvisited) {

            String kmer = kmers.get(next);

            if (kmer.startsWith(prefix)) {


                builder.append(kmer.charAt(k - 1));

                remaining.addAll(unvisited);

                remaining.remove(next);

                if (traverse(k, kmers, remaining, builder)) {

                    return true;

                }

                remaining.clear();

                builder.delete(builder.length() - 1, builder.length());

            }
        }
        return false;
    }
}