package chapter5.item32;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String  hello = "안녕";
        String[] strings = pickTwo(hello, "하세", "요오");// 해결 전
//        List<String> stringList = (List<String>) pickTwo("안녕", "하세", "123");// 해결 후
//        System.out.println("stringList = " + stringList);
//        System.out.println("stringList = " + stringList.getClass().getTypeParameters().getClass().getGenericSuperclass().getTypeName());
//        System.out.println("stringList.get(0) = " + stringList.get(0));
        List<String> asss = new ArrayList<>();
        List<Object> asd1
                = List.of("ASD", 123);
        System.out.println("asd1 = " + asd1);
        String[] obs = new String[2];
        obs[0] = "ASd";
        obs[1] = "WE";

        System.out.println("obs = " + obs);
        String[] strings2 = toArray(obs);
        if (strings2 instanceof String[]) {
            System.out.println("String========================");
        }
        Object[] strings3 = (String[])toArray(obs);
        Object[] strings4 = new Object[3];
//        Object[] strings41 = (String[]) strings4; //cast error
        if (strings3 instanceof Object[]) {
            System.out.println("Object======================");
        }
        System.out.println("strings3 = " + strings3);
        String a = "a";
        String b = "b";


        String c = "c";
        String[] raw = toArray("I", "LOVE", "JAVA");
        String[] raw2 = toArray(a, b, c);
        System.out.println("raw = " + raw);
        System.out.println("raw2 = " + raw2);
        System.out.println("objects = " + strings2[0]);

//        System.out.println("serializables = " + serializables);
//        System.out.println("strings = " + strings);
//        System.out.println(serializables.getClass().getName());
//        System.out.println("serializables = " + serializables);
    }

    static <T> T[] toArray(T... args) {
        if (args instanceof String[]) {
            System.out.println("ASD");
        }
        return args;
    }

    // 에러
    static <T> T[] pickTwo(T a, T b, T c) {
        Object checkj = (Object) a;
        System.out.println(checkj.getClass());
        System.out.println("checkj = " + checkj);

        String checkj2 = (String) a;
        System.out.println(checkj2.getClass());
        System.out.println("checkj2 = " + checkj);

        if (a instanceof String) {
            System.out.println("ASD@@@@");
        }
//        switch (ThreadLocalRandom.current().nextInt(3)) {
//            case 0:
//                return toArray("ASD", "ASD");
//            case 1:
//                return toArray(a, c);
//            case 2:
//                return toArray(b, c);
//
//        }
//        throw new AssertionError();
        return toArray(a, b, c);
//        return (T[]) toArray("asd");
    }

    // 해결

//    static <T> List<T> pickTwo(T a, T b, T c) {
//        List<T> a1 = List.of(a, b, c);
//        return a1;
//    }
}

