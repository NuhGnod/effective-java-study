package item32;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
//        Serializable[] serializables = pickTwo("안녕", "하세", 132);
        Object[] obs = new String[2];

        System.out.println("obs = " + obs);
//        System.out.println("serializables = " + serializables);
//        System.out.println("strings = " + strings);
    }

    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        return toArray(a, b, c);
    }
}

