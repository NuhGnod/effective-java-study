package chapter5.item26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        if (strings instanceof Set<?>) {

        }
        List raw = new ArrayList();
        List<Object> objects = new ArrayList<>();

        unsafeAdd(raw, new Object());
        unsafeAdd(objects, new Object());

        unsafeAdd(strings, Integer.valueOf(123));
        System.out.println(strings);
//        System.out.println("strings.get(0) = " + strings.get(0));
        System.out.println(raw);
        System.out.println("raw.get(0) = " + raw.get(0));

        System.out.println(objects);
        System.out.println("objects.get(0) = " + objects.get(0));
        System.out.println("==================================");

        Set<String> set1 = new HashSet<>();
        set1.add("Hi");
        Set<String> set2 = new HashSet<>();
        set2.add("Hi");

        Set<?> wild = new HashSet<>();
        Set<?> wild2 = Set.of("a", "b", "c");
        System.out.println(wild2);
//        wild.add("asd");
        int i = numElementsInCommon(set1, set2);

        Class<List> listClass = List.class;
        Class<String[]> aClass = String[].class;
        Class<Integer> integerClass = int.class;
//        Class<List<String>> listClass1 = new ArrayList<String>().getClass();
//        List<String>.class; //error
//        List<?>.class; //error

        if (wild instanceof Set) {
            Set<?> s = (Set<?>) wild;
            Set<String> s1 = (Set<String>) wild;
        }
        if (set1 instanceof Set) {
            Set<?> s = (Set<?>) wild;
            Set<String> s1 = (Set<String>) wild;
        }
    }

    /**
     * Raw타입은 제네릭 타입에서 타입 매개변수를 전혀 사용하지 않은 것.
     * 타입선언에서 제네릭 타입 정보가 전부 지워진 것처럼 동작.
     * e.g)
     * unsafeAdd(List<String>, 123)
     * ->
     * unsafeAdd(List, 123)
     * 과 마찬가지다.
     * 따라서 어떤 타입이든 list.add(o) 실행가능
     * but, unchecked Exception warning
     * main의 body에서 형변환 시도 시 ClassCastException 발생.
     * 즉, Raw타입은 제네릭이 가져다주는 안전성과 표현력을 모두 잃게 된다.
     *
     *
     * @param list
     * @param o
     */
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    /**
     * 타입 매개변수가 Object타입인 제네릭 메서드
     *
     * @param list
     * @param o`
     */
//    private static void unsafeAdd(List<Object> list, Object o) {
//        list.add(o);
//    }

    /**
     * 비한정적 와일드 카드 사용
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o : s1) {
            if (s2.contains(o)) {
                result++;
            }
        }
        return result;
    }
}
