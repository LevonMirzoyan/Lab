import java.util.Scanner;

public class lab1_7 {
    public static void main(String[] args) {
        HammingDistance Ham = new HammingDistance();
        Ham.print(Ham.countI());
    }
}

class HammingDistance{
    HammingDistance(){
        Scanner in = new Scanner(System.in);
        str1 =  in.next();
        str2 = in.next();
    }


    int countI(){
        int n = str1.length();
        int count=0;
        for (int i=0; i<n; i++){
            if (str1.charAt(i)!=str2.charAt(i)){
                count++;
            }
        }
        return count;
    }

    void print(int count){

        System.out.print(count);
    }
    String str1;
    String str2;
}