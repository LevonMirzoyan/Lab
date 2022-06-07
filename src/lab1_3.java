import java.util.*;

public class lab1_3 {

    public static void main(String[] args) {
        ReverseComplementofAStringImpl cl =
                new  ReverseComplementofAStringImpl();
        cl.calc();
        cl.print();
    }
}
class ReverseComplementofAStringImpl {

    ReverseComplementofAStringImpl(){
        Scanner in = new Scanner(System.in);
        text = in.next();
    }

    String reverseComplementofAString(String text){
        int len = text.length();
        char[] reverse = new char[len];
        for (int i=0; i < len; i++){

            reverse[len - i -1] = switch(text.charAt(i)) {
                case 'A'-> 'T';
                case 'C'-> 'G';
                case 'G'-> 'C';
                case 'T'-> 'A';
                default -> ' ';
            };
        }
        return String.valueOf(reverse);
    }

    void calc(){
        answer = reverseComplementofAString(text);
    }
    void print(){

        System.out.println(answer);
    }

    String answer;
    String text;
}