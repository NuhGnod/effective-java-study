package chapter5.item30;

import java.util.*;
import java.util.function.UnaryOperator;

public class Main {
       public static <E extends Comparable<? super E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("collection is empty");
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
           System.out.println(result);

        return result;

    }

    ///////////////////////////////
    // 기존 방식
//    private static UnaryOperator<Object> IDENTITY_FN = new UnaryOperator<Object>() {
//        @Override
//        public Object apply(Object o) {
//            return "Hello";
//        }
//    };
    // 람다식 사용. (apply 를 정의한 것?)
    private static UnaryOperator<Object> IDENTITY_FN = t -> "NULL";
//            (t) -> t;

    public static <T> UnaryOperator<T> identyfyFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strins = {"가", "나", "다"};
        UnaryOperator<String> sameString = identyfyFunction();
        UnaryOperator<Object> identity = UnaryOperator.identity();
        System.out.println("identity = " + identity);
//        identity
        Object apply = identity.apply(1);
        System.out.println("apply = " + apply);
        for (String s : strins) {

            System.out.println(sameString.apply(s));
        }
        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identyfyFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }

        List<Integer> list = List.of(2, 14, 5, 11, 3);
        String max = max(List.of("A", "B", "C"));

        System.out.println(max);
        System.out.println(max(list));

    }
}
