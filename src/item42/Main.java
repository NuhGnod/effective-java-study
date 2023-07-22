package item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("ga");
        words.add("na");
        words.add("da");
        words.add("la");
        words.add("ma");
        // v1
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        // v2
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // v3
        Collections.sort(words, Comparator.comparingInt(String::length));

        //v4
        words.sort(Comparator.comparingInt(String::length));
// Enum

        double apply = Operation.DIVIDE.apply(10, 2);
        System.out.println("apply = " + apply);

    }
}
