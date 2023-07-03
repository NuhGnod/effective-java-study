package item32;

import java.io.Serializable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String[] strings = pickTwo("안녕", "하세", "요오"); // 해결 전
        List<? extends Serializable> serializables = pickTwo("안녕", "하세", 123);// 해결 후

        String[] obs = new String[2];
        obs[0] = "ASd";
        obs[1] = "WE";
        System.out.println("obs = " + obs);
        String[] strings2 = toArray(obs);
        System.out.println("objects = " + strings2[0]);
//        System.out.println("serializables = " + serializables);
//        System.out.println("strings = " + strings);
        System.out.println(serializables.getClass().getName());
        System.out.println("serializables = " + serializables);
    }

    // 에러
    static <T> T[] toArray(T... args) {
        return args;
    }

//    static <T> T[] pickTwo(T a, T b, T c) {
//        return toArray(a, b, c);
//    }
    // 해결

    static <T> List<T> pickTwo(T a, T b, T c) {
        return List.of(a, b, c);
    }
}

