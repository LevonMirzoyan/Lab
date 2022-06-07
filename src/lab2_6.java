import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class lab2_6 {
    public static void main(String args[]){
        new_task6 IME = new new_task6();
    }
}

class new_task6{

    int k, t;
    ArrayList<String> Dna;
    ArrayList<String> res1;
    int res2;
    final Random random = new Random();

    double probability_of_kmer(String str, ArrayList<ArrayList<Double>> matrix) {
        double probability = 1.0;
        for(int i = 0; i<str.length(); i++) {
            if(str.contains("A")) {
                probability *= matrix.get(0).get(i);
            }
            if(str.contains("C")) {
                probability *= matrix.get(1).get(i);
            }
            if(str.contains("G")) {
                probability *= matrix.get(2).get(i);
            }
            if(str.contains("T")) {
                probability *= matrix.get(3).get(i);
            }
        }
        return probability;
    }

    String profile_most_probable_kmer(String str, ArrayList<ArrayList<Double>> matrix){
        Map<String, Double> kmer_probability = new HashMap<>();
        for(int i = 0; i<str.length()-k+1; i++) {
            kmer_probability.put(str.substring(i, i+k),probability_of_kmer(str.substring(i, i+k), matrix));
        }
        Double max = -1.0;
        String max_key = "";
        for(String elem: kmer_probability.keySet()) {
            if(kmer_probability.get(elem)>max) {
                max = kmer_probability.get(elem);
                max_key = elem;
            }
        }
        return max_key;
    }
    ArrayList<String> test = new ArrayList<String>();
    int getScore(ArrayList<String> Motifs){
//		test.add("GGGGTGTT");
//		test.add("AAGTGCCA");
//		test.add("ACAGGCGT");
//		test.add("TCAAGTTT");
//		test.add("AGCTCCAC");
        int count_score = 0;
//		Motifs = test;
        for(int i=0; i<Motifs.get(0).length(); i++) {
            ArrayList<String> j = new ArrayList<>();
            for(String motifs: Motifs) {
                j.add(motifs.substring(i, i+1));
            }
            int countA = 0, countC = 0, countT = 0, countG = 0;
            for(String l: j) {
                if(l.contains("A"))
                    countA++;
                if(l.contains("C"))
                    countC++;
                if(l.contains("T"))
                    countT++;
                if(l.contains("G"))
                    countG++;
            }
            int max = -1;
            if(countA>max)
                max = countA;
            if(countC>max)
                max = countC;
            if(countT>max)
                max = countT;
            if(countG>max)
                max = countG;
            count_score += (j.size() - max);
        }
        return count_score;
    }


    ArrayList<String> get_random_motifs(){
        ArrayList<String> motifs = new ArrayList<String>();
        ArrayList<Integer> kmer_index = new ArrayList<>();
        for(int i=0; i<Dna.size(); i++) {
            //System.out.println(random.nextInt(Dna.get(0).length()-k));
            kmer_index.add(random.nextInt(Dna.get(0).length()-k));
        }
//		for(int i=0; i<Dna.size(); i++) {
//			kmer_index.add(random.nextInt(Dna.get(0).length()-k));
//		}
        int i = 0;
        for(int j: kmer_index) {
            motifs.add(Dna.get(i).substring(j, j+k));
        }
        return motifs;
    }

    ArrayList<ArrayList<Double>> create_profile_with_pseudocounts(ArrayList<String> motifs){
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        String[] arr = new String[4];
        arr[0] = "A"; arr[1] = "C"; arr[2] = "G"; arr[3] = "T";
        for(String base: arr) {
            ArrayList<Double> row = new ArrayList<>();
            for(int j=0; j<motifs.get(0).length(); j++) {
                ArrayList<String> col = new ArrayList<>();
                for(String x: motifs) {
                    col.add(x.substring(j, j+1));
                    int counter = 0;
                    for(String a: col) {
                        if(a.contains(base)) {
                            counter++;
                        }
                    }
                    row.add((double) ((counter+1)/motifs.size()+4));
                }
                matrix.add(row);
            }
        }
        return matrix;
    }

    void randomized_motif_search(){
        ArrayList<String> motifs = get_random_motifs();
        ArrayList<String> bestMotifs = motifs;
        int bestScore = getScore(bestMotifs);
        boolean flag = true;
        while(flag) {
            ArrayList<ArrayList<Double>> profile = create_profile_with_pseudocounts(motifs);
            for(int i = 0; i<Dna.size(); i++) {
                motifs.add(profile_most_probable_kmer(Dna.get(i), profile));
                int current_score = getScore(motifs);
                if(current_score < bestScore) {
                    bestMotifs = motifs;
                    bestScore = current_score;
                }
                else {
                    res1 = bestMotifs;
                    res2 = bestScore;
                    flag = false;
                }
            }
        }
    }

    new_task6(){
        Scanner in = new Scanner(System.in);
        Dna = new ArrayList<String>();
        k = in.nextInt();
        t = in.nextInt();
        while(in.hasNext()) {
            String str = in.next();
            Dna.add(str);
        }
        in.close();
        ArrayList<Integer> allScores = new ArrayList<>();
        ArrayList<ArrayList<String>>allMotifs = new ArrayList<>();
        for(int i = 0; i<1000; i++) {
//			System.out.println(i);
            randomized_motif_search();
            allScores.add(res2);
            allMotifs.add(res1);
        }
        int minVal = Integer.MAX_VALUE;
        for(int i: allScores) {
//			System.out.println(i);
            if(i<minVal) {
                minVal = i;
            }
        }
        System.out.println(minVal);
        ArrayList<String> bestMotofs = new ArrayList<>();
        bestMotofs.addAll(allMotifs.get(allScores.get(minVal)));
        for(String i: bestMotofs) {
            System.out.println(i);
        }
    }
}