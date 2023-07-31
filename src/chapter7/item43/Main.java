package chapter7.item43;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        HOP hop = function1(HOP::new);// 정적. 0살
        boolean b = function2(HOP.now()::isOlder, hop);// 한정적
        System.out.println(b);
        boolean b1 = function3(HOP::isAdult, hop);// 비한정적
        System.out.println("b1 = " + b1);
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
