package chapter7.item45;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class Main {
    private static int THRESHOLD = 3;

    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("staple");
        dictionary.add("aelpst");
        dictionary.add("petals");
        dictionary.add("petaldv");
        dictionary.add("ptealdv");
        dictionary.add("peatldv");

        HashMap<String, Set<String>> groups = new HashMap<>();

        // v1

        for (String s : dictionary) {
            groups.computeIfAbsent(alphabetize(s), // s가 있으면 삽입, 없으면 function수행.
                    (unused) -> new TreeSet<>()).add(s);
        }
//        System.out.println("groups = " + groups);
        System.out.println("v1 ===================");
        for (Set<String> group : groups.values()) {
            if (group.size() >= THRESHOLD) {
                System.out.println(group.size() + " : " + group);
            }
        }
        // v2
        System.out.println("v2 ==================");
        dictionary.stream().collect(Collectors.groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= THRESHOLD)
                .forEach(g -> System.out.println(g.size() + " : " + g));

        Collection<List<String>> values = dictionary.stream().collect(Collectors.groupingBy(word -> alphabetize(word)))
                .values();
        Set<String> strings = dictionary.stream().collect(Collectors.groupingBy(word -> alphabetize(word)))
                .keySet();
        System.out.println("grouping key set = " + strings);
        System.out.println("grouping values = " + values);

        // Mersenne prime

        // 100 미만의 소수 출력.
        Stream<BigInteger> primes = primes();
        primes.filter(prime -> prime.compareTo(BigInteger.valueOf(100L)) == -1)
                .limit(10)
                .forEach(prime -> System.out.print(prime + " "));

        System.out.println();
        // 처음 20개의 메르센 소수 출력.
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
//                .forEach(System.out::println);
                .forEach(mp -> System.out.println(mp.bitLength() + ": "+mp));
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
