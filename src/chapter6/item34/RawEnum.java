package chapter6.item34;

import java.util.Arrays;
import java.util.HashMap;

//public class RawEnum {
//    static final HashMap<String, RawEnum> map = new HashMap<>();
//
//    static final RawEnum ONE = new RawEnum(1);
//    static final RawEnum TWO = new RawEnum(1);
//    static final RawEnum THREE = new RawEnum(1);
//    static final int a = 1341421421;
//    static final String s = "kimdonghun";
//    static final Object a2 = new Object();
//    private int number;
//
//
//    public RawEnum(int number) {
//        this.number = number;
//        map.put("one", RawEnum.ONE);
//    }
//}
public class RawEnum {

    static final RawEnum ONE = new RawEnum(1);
    static final RawEnum TWO = new RawEnum(2);
    static final RawEnum THREE = new RawEnum(3);

    private int number;

    public RawEnum(int number) {
        this.number = number;
        RawEnum one = RawEnum.ONE;
        System.out.println("one = " + one);
    }
    public int plus(RawEnum first, RawEnum second) {
        return first.number + second.number;
    }

    public static void main(String[] args) {
//        RawEnum one = RawEnum.ONE;
//        System.out.println("one = " + one);

    }
}
enum Enum {
    ONE(1),
    TWO(2),
    THREE(3),;
    private int number;

    Enum(int number) {
        this.number = number;
    }
    public int sum(Enum first, Enum second) {
        return first.number + second.number;
    }
    public int sumAll() {
        return Arrays.stream(values())
                .mapToInt(Enum::getNumber)
                .sum();    }

    private int getNumber() {
        return number;
    }
}