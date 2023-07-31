package chapter7.item43;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        HOP hop = function1(HOP::new);// 정적. 0살
        boolean b = function2(HOP.now()::isOlder, hop);// 한정적
        System.out.println(b);
        boolean b1 = function3(HOP::isAdult, hop);// 비한정적
        System.out.println("b1 = " + b1);

        List<String> words = Arrays.asList("ABC", "CD", "EFG");

        // 인자로 넘어온 객체의 메소드를 호출
        // 람다식으로 표현
        words.stream().map(word -> word.toLowerCase())
                .forEach(word -> System.out.println(word));

        // 메소드 참조로 표현
        words.stream().map(String::toLowerCase) // 비한정적.
                .forEach(word -> System.out.println(word));
        List<HOP> hops = Arrays.asList(new HOP(1), new HOP(10), new HOP(5));

        // 새로운 HOP객체가 List의 hop들보다 오래되었냐??
        hops.stream().map(HOP.now()::isOlder).forEach(old -> System.out.println(old));
        hops.stream().map(HOP::isAdult).forEach(adult -> System.out.println(adult));

    }


    private static HOP function1(Supplier<HOP> o) {
        return o.get();
    }

    public static boolean function2(Function<HOP, Boolean> function, HOP other) {
        return function.apply(other);

    }

    public static boolean function3(Function<HOP, Boolean> function, HOP hop) {
        return function.apply(hop);
    }

}

class HOP {

    int age;

    public HOP(int hop) {
        this.age = hop;
    }

    public HOP() {

    }

    public static HOP now() {

        return new HOP(100);
    }

    public boolean isOlder(HOP hop) {
        return this.age > hop.age;
    }

    public static Boolean isAdult(HOP hop) {
        return hop.age > 19;
    }
}
