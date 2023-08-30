package chapter7.item48;

import java.math.BigInteger;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int dataSize = 100000000;

        // Example using SplittableRandom with parallel stream
        long startTime1 = System.currentTimeMillis();
        SplittableRandom splittableRandom = new SplittableRandom();
        int sumSplittableRandom = splittableRandom.ints(dataSize)
                .parallel()
                .map(Main::someOperation)
                .sum();
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        System.out.println("Using SplittableRandom with parallel stream, Sum: " + sumSplittableRandom + ", Duration: " + duration1 + " ms");

        // Example using Random with sequential stream
        long startTime2 = System.currentTimeMillis();
        java.util.Random random = new java.util.Random();
        int sumRandom = random.ints(dataSize).map(Main::someOperation).sum();
        //parallel() 시 4200ms 가량 걸림.
//                IntStream.generate(random::nextInt)
//                .limit(dataSize)
//                .map(Main::someOperation)
//                .sum();
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println("Using Random with sequential stream, Sum: " + sumRandom + ", Duration: " + duration2 + " ms");
    }

    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static long pi2(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    // Some example operation (e.g., simply doubling the value)
    private static int someOperation(int value) {
        return value * 2;
    }

}
