package chapter5.item32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HealPollution {
    public static void main(String[] args) {
        List<String> stringList = List.of("A");
        List<String> stringList2 = List.of("AB");
        List<String> stringList3 = List.of("ABC");
        List<String>[] arr = new List[3];
        arr[0] = stringList;
        arr[1] = stringList2;
        arr[2] = stringList3;
        method(stringList, stringList2, stringList3);
//        method(arr);
        Object c = new Object();
        c = "ASD";
        c = 123;
        System.out.println("c = " + c);
        List<String> strings = Collections.emptyList();

        List<Integer> integers = Collections.emptyList();
        Object oc = integers;
        strings = (List<String>) oc;
        System.out.println("strings = " + strings);

        // 힙 오염 방지.
        some(List.of(stringList2, stringList3, stringList));
    }
    public static void some(List<List<String>> strs) {
        Object ob = strs;
        List<Integer> intList = new ArrayList<>();
        intList.add(43);
        intList.add(433);
        ob = intList;
        String s = strs.get(0).get(0);
        System.out.println("s!! = " + s);
    }

    public static void method(List<String>... strs) {
        if (strs instanceof List[]) {
            System.out.println("#########################");
        }
        List<Integer> intList = new ArrayList<>();
        intList.add(43);
        intList.add(433);
        List<String> stringList = new ArrayList<>();
        Object[] objects = strs;
        List<String>[] listarr = new ArrayList[3];

//        listarr[0] = new ArrayList<>();
//        objects = listarr;
        int[] aa = new int[3];
//        System.out.println(objects.getClass().getTypeName());
//        System.out.println("objects = " + objects);
//        for (Object o : objects) {
//            System.out.println("o = " + o);
//        }

//        System.out.println("strs = " + strs);
//        objects[0] = intList;
//        System.out.println("objects = " + objects);
        String s = (strs[0].get(0));
//        System.out.println("s = " + s);

    }
}
